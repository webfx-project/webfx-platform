package dev.webfx.platform.shared.util.async.impl;

import java.util.function.Function;

// Async API inspired from Vert.x (simplified, without Vert.x context and Netty dependency)

class Otherwise<T> extends Operation<T> implements Listener<T> {

    private final Function<Throwable, T> mapper;

    Otherwise(/*ContextInternal context,*/ Function<Throwable, T> mapper) {
        //super(context);
        this.mapper = mapper;
    }

    @Override
    public void onSuccess(T value) {
        tryComplete(value);
    }

    @Override
    public void onFailure(Throwable failure) {
        T result;
        try {
            result = mapper.apply(failure);
        } catch (Throwable e) {
            tryFail(e);
            return;
        }
        tryComplete(result);
    }
}
