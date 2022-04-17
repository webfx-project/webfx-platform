package dev.webfx.platform.shared.util.async.impl;

import dev.webfx.platform.shared.util.async.Future;

import java.util.function.Function;

// Async API inspired from Vert.x (simplified, without Vert.x context and Netty dependency)

/**
 * Function compose transformation.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
class Composition<T, U> extends Operation<U> implements Listener<T> {

    private final Function<T, Future<U>> successMapper;
    private final Function<Throwable, Future<U>> failureMapper;

    Composition(/*ContextInternal context,*/ Function<T, Future<U>> successMapper, Function<Throwable, Future<U>> failureMapper) {
        //super(context);
        this.successMapper = successMapper;
        this.failureMapper = failureMapper;
    }

    @Override
    public void onSuccess(T value) {
        FutureInternal<U> future;
        try {
            future = (FutureInternal<U>) successMapper.apply(value);
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
            future = (FutureInternal<U>) failureMapper.apply(failure);
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

