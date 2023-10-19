package dev.webfx.platform.async.impl;

// Async API inspired from Vert.x (simplified, without Vert.x context and Netty dependency)

/**
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class NoStackTraceThrowable extends Throwable {

    public NoStackTraceThrowable(String message) {
        super(message, null, false, false);
        // Added stack trace to watch "Connection reset" issue on AWS
        new Exception("NoStackTraceThrowable stack trace:").printStackTrace();
    }
}
