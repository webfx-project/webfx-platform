package dev.webfx.platform.shared.util.async.impl;

import dev.webfx.platform.shared.util.async.AsyncResult;
import dev.webfx.platform.shared.util.async.Future;

// Async API inspired from Vert.x (simplified, without Vert.x context and Netty dependency)

/**
 * Promise implementation.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public final class PromiseImpl<T> extends FutureImpl<T> implements PromiseInternal<T>, Listener<T> {

    /**
     * Create a promise that hasn't completed yet
     */
    public PromiseImpl() {
        super();
    }

    /**
     * Create a promise that hasn't completed yet
     */
    /*public PromiseImpl(ContextInternal context) {
        super(context);
    }*/

    public void handle(AsyncResult<T> ar) {
        if (ar.succeeded()) {
            onSuccess(ar.result());
        } else {
            onFailure(ar.cause());
        }
    }

    @Override
    public void onSuccess(T value) {
        tryComplete(value);
    }

    @Override
    public void onFailure(Throwable failure) {
        tryFail(failure);
    }

    @Override
    public Future<T> future() {
        return this;
    }

    /*@Override
    public void operationComplete(io.netty.util.concurrent.Future<T> future) {
        if (future.isSuccess()) {
            complete(future.getNow());
        } else {
            fail(future.cause());
        }
    }*/
}

