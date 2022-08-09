package dev.webfx.platform.async.impl;

import dev.webfx.platform.async.Future;

// Async API inspired from Vert.x (simplified, without Vert.x context and Netty dependency)

/**
 * Expose some of the future internal stuff.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public interface FutureInternal<T> extends Future<T> {

    /**
     * @return the context associated with this promise or {@code null} when there is none
     */
    //ContextInternal context();

    /**
     * Add a listener to the future result.
     *
     * @param listener the listener
     */
    void addListener(Listener<T> listener);

}
