package dev.webfx.platform.secret;

/**
 * Raised when an encrypted file can't be read: a malformed or truncated file, parameters this
 * version doesn't know, or a passphrase that doesn't open it (see {@link WrongPassphraseException}).
 *
 * @author Bruno Salmon
 */
public class SecretException extends RuntimeException {

    public SecretException(String message) {
        super(message);
    }

    public SecretException(String message, Throwable cause) {
        super(message, cause);
    }
}
