package dev.webfx.platform.shared.util.async.impl;

import java.util.function.Function;

// Async API inspired from Vert.x (simplified, without Vert.x context and Netty dependency)

/**
 * Function map transformation.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
class Mapping<T, U> extends Operation<U> implements Listener<T> {

    private final Function<T, U> successMapper;

    Mapping(/*ContextInternal context,*/ Function<T, U> successMapper) {
        //super(context);
        this.successMapper = successMapper;
    }

    @Override
    public void onSuccess(T value) {
        U result;
        try {
            result = successMapper.apply(value);
        } catch (Throwable e) {
            tryFail(e);
            return;
        }
        tryComplete(result);
    }

    @Override
    public void onFailure(Throwable failure) {
        tryFail(failure);
    }
}
