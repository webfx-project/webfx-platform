package dev.webfx.platform.shared.util.async.impl;

import dev.webfx.platform.shared.util.async.AsyncResult;
import dev.webfx.platform.shared.util.async.Future;

import java.util.function.Function;

// Async API inspired from Vert.x (simplified, without Vert.x context and Netty dependency)

/**
 * Function compose transformation.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
class Transformation<T, U> extends Operation<U> implements Listener<T> {

    private final Future<T> future;
    private final Function<AsyncResult<T>, Future<U>> mapper;

    Transformation(/*ContextInternal context,*/ Future<T> future, Function<AsyncResult<T>, Future<U>> mapper) {
        //super(context);
        this.future = future;
        this.mapper = mapper;
    }

    @Override
    public void onSuccess(T value) {
        FutureInternal<U> future;
        try {
            future = (FutureInternal<U>) mapper.apply(this.future);
        } catch (Throwable e) {
            tryFail(e);
            return;
        }
        future.addListener(newListener());
    }

    @Override
    public void onFailure(Throwable failure) {
        FutureInternal<U> future;
        try {
            future = (FutureInternal<U>) mapper.apply(this.future);
        } catch (Throwable e) {
            tryFail(e);
            return;
        }
        future.addListener(newListener());
    }

    private Listener<U> newListener() {
        return new Listener<U>() {
            @Override
            public void onSuccess(U value) {
                tryComplete(value);
            }
            @Override
            public void onFailure(Throwable failure) {
                tryFail(failure);
            }
        };
    }
}

