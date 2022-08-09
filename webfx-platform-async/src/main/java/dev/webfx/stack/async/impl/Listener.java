package dev.webfx.stack.async.impl;

// Async API inspired from Vert.x (simplified, without Vert.x context and Netty dependency)

/**
 * Internal listener that signals success or failure when a future completes.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public interface Listener<T> {

    /**
     * Signal the success.
     *
     * @param value the value
     */
    void onSuccess(T value);

    /**
     * Signal the failure
     *
     * @param failure the failure
     */
    void onFailure(Throwable failure);
}