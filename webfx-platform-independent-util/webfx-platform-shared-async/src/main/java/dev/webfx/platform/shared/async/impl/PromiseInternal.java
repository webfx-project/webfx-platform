package dev.webfx.platform.shared.async.impl;

import dev.webfx.platform.shared.async.Promise;

// Async API inspired from Vert.x (simplified, without Vert.x context and Netty dependency)

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public interface PromiseInternal<T> extends Promise<T>, /*FutureListener<T>,*/ FutureInternal<T> {

    /**
     * @return the context associated with this promise or {@code null} when there is none
     */
    //ContextInternal context();

}