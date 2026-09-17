package dev.webfx.platform.async.util;

/**
 * Thrown when an {@link AsyncQueue} operation submitted with {@code rejectIfWouldWait} is refused
 * admission because the executing set is at capacity — the operation is shed instead of queued.
 * <p>
 * Intended for optional background work (e.g. cache revalidations) that callers prefer to skip
 * under load rather than let pile up in the waiting queue. The message deliberately starts with
 * the {@code "ServerBusy"} sentinel: error replies over the bus carry the message string only
 * (the exception type is erased by the serialization), so remote callers detect a shed by that
 * prefix — and a prefix starting with {@code "Server"} survives the Java clients' generic
 * "Server error: " message rewriting untouched.
 *
 * @author Bruno Salmon
 */
public class SheddedOperationException extends RuntimeException {

    /** Message prefix remote callers match on to recognise a shed (see class javadoc). */
    public static final String SERVER_BUSY_PREFIX = "ServerBusy";

    public SheddedOperationException(String message) {
        super(message);
    }
}
