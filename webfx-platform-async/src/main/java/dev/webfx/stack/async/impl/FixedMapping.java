package dev.webfx.stack.async.impl;

// Async API inspired from Vert.x (simplified, without Vert.x context and Netty dependency)

/**
 * Map value transformation.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
class FixedMapping<T, U> extends Operation<U> implements Listener<T> {

    private final U value;

    FixedMapping(/*ContextInternal context,*/ U value) {
        //super(context);
        this.value = value;
    }

    @Override
    public void onSuccess(T value) {
        tryComplete(this.value);
    }

    @Override
    public void onFailure(Throwable failure) {
        tryFail(failure);
    }
}

