package dev.webfx.platform.secret;

import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

/**
 * Encrypts and decrypts a configuration file with a passphrase, so that secrets don't have to be
 * stored in clear on a developer machine.
 *
 * <p>The encrypted form is text: a header line in clear holding the parameters needed to read it
 * back, then the encrypted content in base64. For example:
 * <pre>
 * #webfx-secret v1 pbkdf2-hmac-sha256 600000 Xq3n… 8fKd…
 * ntQZ0uW1…
 * …
 * </pre>
 * The content is encrypted with AES-256-GCM, under a key derived from the passphrase by PBKDF2, with
 * a fresh salt and nonce written on every save. The parameters from the header are authenticated
 * along with the content, so a file whose header was edited - to point at a cheaper key derivation,
 * say - fails to decrypt rather than being read on those terms.
 *
 * <p>Everything here uses the JDK only, so the same class serves the server reading a file and the
 * command line tool writing one.
 *
 * @author Bruno Salmon
 */
public final class SecretCipher {

    private static final String MAGIC = "#webfx-secret";
    private static final String VERSION = "v1";
    private static final String KDF = "pbkdf2-hmac-sha256";
    private static final String KDF_ALGORITHM = "PBKDF2WithHmacSHA256";
    // OWASP's recommendation for PBKDF2-HMAC-SHA256. It costs a fraction of a second once per file,
    // and is what stands between a stolen file and an offline search for the passphrase.
    private static final int KDF_ITERATIONS = 600_000;
    private static final int KEY_BITS = 256;
    private static final int SALT_BYTES = 16;
    private static final int NONCE_BYTES = 12; // 96 bits, the size AES-GCM is defined for
    private static final int TAG_BITS = 128;
    private static final int BODY_LINE_LENGTH = 76;
    // A file says how many iterations to run, and that is read before the authentication tag can reject a tampered
    // header - so it is capped, or a header saying "two billion" would hang a start for minutes.
    private static final int MAX_KDF_ITERATIONS = 10_000_000;

    private static final SecureRandom RANDOM = new SecureRandom();

    private SecretCipher() {}

    /** Whether this text is an encrypted file, i.e. starts with the header line. */
    public static boolean isEncrypted(String fileText) {
        return fileText != null && fileText.stripLeading().startsWith(MAGIC + " ");
    }

    public static String encrypt(String plainText, char[] passphrase) {
        Header header = new Header(VERSION, KDF, KDF_ITERATIONS, randomBytes(SALT_BYTES), randomBytes(NONCE_BYTES));
        byte[] plainBytes = plainText.getBytes(StandardCharsets.UTF_8);
        try {
            byte[] encrypted = crypt(Cipher.ENCRYPT_MODE, header, passphrase, plainBytes);
            return header.line() + "\n" + wrapBase64(Base64.getEncoder().encodeToString(encrypted));
        } finally {
            Arrays.fill(plainBytes, (byte) 0);
        }
    }

    public static String decrypt(String fileText, char[] passphrase) {
        if (!isEncrypted(fileText))
            throw new SecretException("Not an encrypted file (no " + MAGIC + " header line)");
        String[] lines = fileText.stripLeading().split("\n");
        Header header = Header.parse(lines[0].trim());
        StringBuilder base64 = new StringBuilder();
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i].trim();
            if (!line.isEmpty() && !line.startsWith("#")) // comment lines may be added freely
                base64.append(line);
        }
        byte[] encrypted;
        try {
            encrypted = Base64.getDecoder().decode(base64.toString());
        } catch (IllegalArgumentException e) {
            throw new SecretException("The encrypted content is not valid base64 - the file looks damaged", e);
        }
        byte[] decrypted = crypt(Cipher.DECRYPT_MODE, header, passphrase, encrypted);
        try {
            return new String(decrypted, StandardCharsets.UTF_8);
        } finally {
            Arrays.fill(decrypted, (byte) 0);
        }
    }

    private static byte[] crypt(int mode, Header header, char[] passphrase, byte[] input) {
        SecretKey key = deriveKey(passphrase, header);
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(mode, key, new GCMParameterSpec(TAG_BITS, header.nonce));
            cipher.updateAAD(header.authenticatedParameters()); // binds the content to its header
            return cipher.doFinal(input);
        } catch (AEADBadTagException e) {
            throw new WrongPassphraseException("Wrong passphrase, or the file was modified after it was written", e);
        } catch (GeneralSecurityException e) {
            throw new SecretException("Could not " + (mode == Cipher.ENCRYPT_MODE ? "encrypt" : "decrypt") + " (" + e + ")", e);
        } finally {
            try {
                key.destroy(); // no-op on most JDK implementations, but correct to ask
            } catch (Exception ignored) { }
        }
    }

    private static SecretKey deriveKey(char[] passphrase, Header header) {
        if (passphrase == null || passphrase.length == 0)
            throw new SecretException("No passphrase given");
        PBEKeySpec keySpec = new PBEKeySpec(passphrase, header.salt, header.iterations, KEY_BITS);
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance(KDF_ALGORITHM).generateSecret(keySpec).getEncoded(), "AES");
        } catch (GeneralSecurityException e) {
            throw new SecretException("Could not derive the key from the passphrase (" + e + ")", e);
        } finally {
            keySpec.clearPassword();
        }
    }

    private static byte[] randomBytes(int length) {
        byte[] bytes = new byte[length];
        RANDOM.nextBytes(bytes);
        return bytes;
    }

    private static String wrapBase64(String base64) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < base64.length(); i += BODY_LINE_LENGTH)
            sb.append(base64, i, Math.min(i + BODY_LINE_LENGTH, base64.length())).append('\n');
        return sb.toString();
    }

    /** The parameters needed to read the file back, written in clear and authenticated with the content. */
    private record Header(String version, String kdf, int iterations, byte[] salt, byte[] nonce) {

        static Header parse(String line) {
            String[] tokens = line.split("\\s+");
            if (tokens.length != 6)
                throw new SecretException("Malformed header line in the encrypted file");
            if (!VERSION.equals(tokens[1]))
                throw new SecretException("Encrypted file version " + tokens[1] + " is not supported by this version of WebFX");
            if (!KDF.equals(tokens[2]))
                throw new SecretException("Unsupported key derivation " + tokens[2] + " in the encrypted file");
            int iterations;
            try {
                iterations = Integer.parseInt(tokens[3]);
            } catch (NumberFormatException e) {
                throw new SecretException("Malformed iteration count in the encrypted file", e);
            }
            if (iterations < 1 || iterations > MAX_KDF_ITERATIONS)
                throw new SecretException("Iteration count " + iterations + " in the encrypted file is out of the"
                                          + " supported range (1.." + MAX_KDF_ITERATIONS + ")");
            try {
                return new Header(tokens[1], tokens[2], iterations, Base64.getDecoder().decode(tokens[4]), Base64.getDecoder().decode(tokens[5]));
            } catch (IllegalArgumentException e) {
                throw new SecretException("Malformed salt or nonce in the encrypted file", e);
            }
        }

        String line() {
            return MAGIC + " " + version + " " + kdf + " " + iterations + " "
                   + Base64.getEncoder().encodeToString(salt) + " " + Base64.getEncoder().encodeToString(nonce);
        }

        /** The canonical parameters, so incidental edits (spacing, added comments) don't break a file, but changed parameters do. */
        byte[] authenticatedParameters() {
            return (MAGIC + ";" + version + ";" + kdf + ";" + iterations + ";"
                    + Base64.getEncoder().encodeToString(salt) + ";" + Base64.getEncoder().encodeToString(nonce))
                    .getBytes(StandardCharsets.UTF_8);
        }
    }
}
