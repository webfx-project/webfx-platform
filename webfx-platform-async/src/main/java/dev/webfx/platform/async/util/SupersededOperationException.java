package dev.webfx.platform.async.util;

/**
 * Thrown when a pending {@link AsyncQueue} operation is cancelled because a newer operation
 * with the same {@code sourceId} was submitted while it was still waiting.
 *
 * @author Bruno Salmon
 */
public class SupersededOperationException extends RuntimeException {

    public SupersededOperationException(String message) {
        super(message);
    }
}
