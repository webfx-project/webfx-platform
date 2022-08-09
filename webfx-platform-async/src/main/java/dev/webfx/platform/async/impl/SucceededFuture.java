package dev.webfx.platform.async.impl;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Handler;
import dev.webfx.platform.async.AsyncResult;

import java.util.Objects;
import java.util.function.Function;

// Async API inspired from Vert.x (simplified, without Vert.x context and Netty dependency)

/**
 * Succeeded future implementation.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public final class SucceededFuture<T> extends FutureBase<T> {

    /**
     * Stateless instance of empty results that can be shared safely.
     */
    public static final SucceededFuture EMPTY = new SucceededFuture(/*null,*/ null);

    private final T result;

    /**
     * Create a future that has already succeeded
     * @param result the result
     */
    public SucceededFuture(T result) {
        //this(null, result);
        this.result = result;
    }

    /**
     * Create a future that has already succeeded
     * //@param context the context
     * //@param result the result
     */
    /*public SucceededFuture(ContextInternal context, T result) {
        super(context);
        this.result = result;
    }*/

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public Future<T> onSuccess(Handler<T> handler) {
        /*if (context != null) {
            context.emit(result, handler);
        } else {*/
            handler.handle(result);
        //}
        return this;
    }

    @Override
    public Future<T> onFailure(Handler<Throwable> handler) {
        return this;
    }

    @Override
    public Future<T> onComplete(Handler<AsyncResult<T>> handler) {
        if (handler instanceof Listener) {
            emitSuccess(result ,(Listener<T>) handler);
        } /*else if (context != null) {
            context.emit(this, handler);
        }*/ else {
            handler.handle(this);
        }
        return this;
    }

    @Override
    public void addListener(Listener<T> listener) {
        emitSuccess(result ,listener);
    }

    @Override
    public T result() {
        return result;
    }

    @Override
    public Throwable cause() {
        return null;
    }

    @Override
    public boolean succeeded() {
        return true;
    }

    @Override
    public boolean failed() {
        return false;
    }

    @Override
    public <V> Future<V> map(V value) {
        return new SucceededFuture<>(/*context,*/ value);
    }

    @Override
    public Future<T> otherwise(Function<Throwable, T> mapper) {
        Objects.requireNonNull(mapper, "No null mapper accepted");
        return this;
    }

    @Override
    public Future<T> otherwise(T value) {
        return this;
    }

    @Override
    public String toString() {
        return "Future{result=" + result + "}";
    }
}

