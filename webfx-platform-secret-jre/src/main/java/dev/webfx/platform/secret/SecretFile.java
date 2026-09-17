package dev.webfx.platform.secret;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * Reading and writing an encrypted configuration file.
 *
 * <p>The name says how to read it: {@code <name>.<format>.secret}, ex:
 * {@code my-variables.properties.secret}. Dropping the {@code .secret} gives back the name the
 * configuration machinery expects, so the format (properties, json, yaml) and the configuration path
 * it contributes to keep their usual meaning.
 *
 * <p>A save never leaves a half-written file, and never a readable one: the content is written to a
 * temporary file in the same directory, readable by its owner only, then moved into place.
 *
 * @author Bruno Salmon
 */
public final class SecretFile {

    public static final String EXTENSION = ".secret";

    private static final Set<PosixFilePermission> OWNER_ONLY = PosixFilePermissions.fromString("rw-------");

    private SecretFile() {}

    public static boolean isSecretFileName(String fileName) {
        return fileName != null && fileName.endsWith(EXTENSION);
    }

    /** The file name without the {@code .secret} extension, ex: my-variables.properties.secret -> my-variables.properties */
    public static String plainFileName(String fileName) {
        if (!isSecretFileName(fileName))
            throw new SecretException("Not an encrypted file name: " + fileName);
        String plainFileName = fileName.substring(0, fileName.length() - EXTENSION.length());
        if (!plainFileName.contains("."))
            throw new SecretException("Encrypted file " + fileName + " doesn't say its format:"
                                      + " name it <name>.<format>" + EXTENSION + ", ex: my-variables.properties" + EXTENSION);
        return plainFileName;
    }

    /** Reads and decrypts the file, returning the configuration text it holds. */
    public static String read(Path file, char[] passphrase) {
        return SecretCipher.decrypt(readText(file), passphrase);
    }

    public static String readText(Path file) {
        try {
            return new String(Files.readAllBytes(file), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException("Could not read " + file, e);
        }
    }

    /** Encrypts the text and replaces the file with it, atomically and readable by its owner only. */
    public static void write(Path file, String plainText, char[] passphrase) {
        String encrypted = SecretCipher.encrypt(plainText, passphrase);
        Path directory = file.toAbsolutePath().getParent();
        Path temporaryFile = null;
        try {
            temporaryFile = createOwnerOnlyTemporaryFile(directory);
            Files.write(temporaryFile, encrypted.getBytes(StandardCharsets.UTF_8));
            try {
                Files.move(temporaryFile, file, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
            } catch (AtomicMoveNotSupportedException e) { // ex: some network or virtual file systems
                Files.move(temporaryFile, file, StandardCopyOption.REPLACE_EXISTING);
            }
            temporaryFile = null;
            restrictToOwner(file);
        } catch (IOException e) {
            throw new UncheckedIOException("Could not write " + file, e);
        } finally {
            if (temporaryFile != null) // the move didn't happen: don't leave the new content lying around
                try { Files.deleteIfExists(temporaryFile); } catch (IOException ignored) { }
        }
    }

    private static Path createOwnerOnlyTemporaryFile(Path directory) throws IOException {
        try {
            return Files.createTempFile(directory, ".webfx-secret", ".tmp", PosixFilePermissions.asFileAttribute(OWNER_ONLY));
        } catch (UnsupportedOperationException e) { // not a POSIX file system (ex: Windows)
            return Files.createTempFile(directory, ".webfx-secret", ".tmp");
        }
    }

    private static void restrictToOwner(Path file) {
        try {
            Files.setPosixFilePermissions(file, OWNER_ONLY);
        } catch (IOException | UnsupportedOperationException ignored) { } // best effort, see above
    }
}
