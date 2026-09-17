package dev.webfx.platform.secret;

import java.util.Arrays;
import java.util.List;

/**
 * Obtains the passphrase that opens the encrypted configuration files, and remembers it for as long
 * as the application runs, so it is asked for once however many files there are.
 *
 * <p>It comes from the {@code WEBFX_SECRET_PASSPHRASE} environment variable when set - for a build
 * or a test that can't answer a prompt - and otherwise from the person starting the application. A
 * passphrase that doesn't open the file is asked again rather than failing the start, since typing
 * or pasting one is easy to get wrong.
 *
 * @author Bruno Salmon
 */
public final class SecretPassphrase {

    // Deliberately an environment variable and NOT a system property: a system property would invite -Dwebfx.secret
    // .passphrase=... on a command line, which puts the passphrase that opens every encrypted file into the process
    // arguments, the shell history, and the run configuration files an IDE writes.
    public static final String ENVIRONMENT_VARIABLE = "WEBFX_SECRET_PASSPHRASE";

    private static final int ATTEMPTS = 3;

    private static char[] rememberedPassphrase;

    private SecretPassphrase() {}

    /**
     * Decrypts the given encrypted text, asking for the passphrase if it isn't known yet.
     *
     * @param fileLabel what to call the file when asking, ex: its name
     * @throws SecretException if the passphrase can't be obtained, or the text can't be decrypted
     */
    public static synchronized String decrypt(String encryptedText, String fileLabel) {
        if (rememberedPassphrase != null) {
            try {
                return SecretCipher.decrypt(encryptedText, rememberedPassphrase);
            } catch (WrongPassphraseException e) {
                // Another file, opened by another passphrase: fall through and ask for this one
            }
        }
        char[] configured = configuredPassphrase();
        if (configured != null) {
            try {
                String decrypted = SecretCipher.decrypt(encryptedText, configured);
                remember(configured);
                return decrypted;
            } catch (WrongPassphraseException e) {
                Arrays.fill(configured, '\0');
                throw new SecretException("The passphrase given by " + ENVIRONMENT_VARIABLE + " doesn't open " + fileLabel, e);
            }
        }
        if (!SecretPrompt.isPossible())
            throw new SecretException(fileLabel + " is encrypted, but there is no way to ask for its passphrase here"
                                      + " (no desktop and no terminal). Set " + ENVIRONMENT_VARIABLE + " instead.");
        WrongPassphraseException lastFailure = null;
        for (int attempt = 1; attempt <= ATTEMPTS; attempt++) {
            char[] typed = SecretPrompt.ask("Passphrase for " + fileLabel,
                    lastFailure == null ? List.of() : List.of("That passphrase didn't open it - try again"),
                    SecretPrompt.Preference.DIALOG_FIRST);
            if (typed == null || typed.length == 0)
                throw new SecretException("No passphrase given for " + fileLabel);
            try {
                String decrypted = SecretCipher.decrypt(encryptedText, typed);
                remember(typed);
                return decrypted;
            } catch (WrongPassphraseException e) {
                Arrays.fill(typed, '\0');
                lastFailure = e;
            }
        }
        throw new SecretException("The passphrase for " + fileLabel + " was wrong " + ATTEMPTS + " times", lastFailure);
    }

    private static char[] configuredPassphrase() {
        String value = System.getenv(ENVIRONMENT_VARIABLE);
        return value == null || value.isEmpty() ? null : value.toCharArray();
    }

    private static void remember(char[] passphrase) {
        if (rememberedPassphrase != passphrase) {
            if (rememberedPassphrase != null)
                Arrays.fill(rememberedPassphrase, '\0');
            rememberedPassphrase = passphrase;
        }
    }

    /** Forgets the passphrase, so the next file asks for it again. Meant for tests. */
    public static synchronized void forget() {
        if (rememberedPassphrase != null) {
            Arrays.fill(rememberedPassphrase, '\0');
            rememberedPassphrase = null;
        }
    }
}
