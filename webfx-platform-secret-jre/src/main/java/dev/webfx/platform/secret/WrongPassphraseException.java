package dev.webfx.platform.secret;

/**
 * The passphrase didn't open the file. Distinguished from other failures so a caller can ask again
 * rather than give up - but note that it also covers a file that was modified after being written,
 * as the authentication tag can't tell the two apart.
 *
 * @author Bruno Salmon
 */
public final class WrongPassphraseException extends SecretException {

    public WrongPassphraseException(String message, Throwable cause) {
        super(message, cause);
    }
}
