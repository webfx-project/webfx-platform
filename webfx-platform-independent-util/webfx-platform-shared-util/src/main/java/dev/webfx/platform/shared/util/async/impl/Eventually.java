package dev.webfx.platform.shared.util.async.impl;

import dev.webfx.platform.shared.util.async.Future;

import java.util.function.Function;

// Async API inspired from Vert.x (simplified, without Vert.x context and Netty dependency)

/**
 * Eventually operation.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
class Eventually<T, U> extends Operation<T> implements Listener<T> {

    private final Function<Void, Future<U>> mapper;

    Eventually(/*ContextInternal context,*/ Function<Void, Future<U>> mapper) {
        //super(context);
        this.mapper = mapper;
    }

    @Override
    public void onSuccess(T value) {
        FutureInternal<U> future;
        try {
            future = (FutureInternal<U>) mapper.apply(null);
        } catch (Throwable e) {
            tryFail(e);
            return;
        }
        future.addListener(new Listener<U>() {
            @Override
            public void onSuccess(U ignore) {
                tryComplete(value);
            }
            @Override
            public void onFailure(Throwable ignore) {
                tryComplete(value);
            }
        });
    }

    @Override
    public void onFailure(Throwable failure) {
        FutureInternal<U> future;
        try {
            future = (FutureInternal<U>) mapper.apply(null);
        } catch (Throwable e) {
            tryFail(e);
            return;
        }
        future.addListener(new Listener<U>() {
            @Override
            public void onSuccess(U ignore) {
                tryFail(failure);
            }
            @Override
            public void onFailure(Throwable ignore) {
                tryFail(failure);
            }
        });
    }
}
