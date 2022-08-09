package dev.webfx.platform.async.impl;

// Async API inspired from Vert.x (simplified, without Vert.x context and Netty dependency)

/**
 * Otherwise value transformation.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
class FixedOtherwise<T> extends Operation<T> implements Listener<T> {

    private final T value;

    FixedOtherwise(/*ContextInternal context,*/ T value) {
        //super(context);
        this.value = value;
    }

    @Override
    public void onSuccess(T value) {
        tryComplete(value);
    }

    @Override
    public void onFailure(Throwable failure) {
        tryComplete(value);
    }
}