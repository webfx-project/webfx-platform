package dev.webfx.platform.async.impl;

// Async API inspired from Vert.x (simplified, without Vert.x context and Netty dependency)

/**
 * Base class for transforming the completion of a future.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
abstract class Operation<T> extends FutureImpl<T> {

    /*protected Operation(ContextInternal context) {
        super(context);
    }*/
}
