package dev.webfx.platform.shared.util.async.impl;

import dev.webfx.platform.shared.util.async.AsyncResult;
import dev.webfx.platform.shared.util.async.Future;
import dev.webfx.platform.shared.util.async.Handler;

import java.util.function.Function;

// Async API inspired from Vert.x (simplified, without Vert.x context and Netty dependency)

/**
 * Failed future implementation.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public final class FailedFuture<T> extends FutureBase<T> {

    private final Throwable cause;

    /**
     * Create a future that has already failed
     * @param t the throwable
     */
    public FailedFuture(Throwable t) {
        //this(null, t);
        this.cause = t != null ? t : new NoStackTraceThrowable(null);
    }

    /**
     * Create a future that has already failed
     * @param t the throwable
     */
    /*public FailedFuture(ContextInternal context, Throwable t) {
        super(context);
        this.cause = t != null ? t : new NoStackTraceThrowable(null);
    }*/

    /**
     * Create a future that has already failed
     * @param failureMessage the failure message
     */
    public FailedFuture(String failureMessage) {
        //this(null, failureMessage);
        this(new NoStackTraceThrowable(failureMessage));
    }

    /**
     * Create a future that has already failed
     * //@param failureMessage the failure message
     */
    /*public FailedFuture(ContextInternal context, String failureMessage) {
        this(context, new NoStackTraceThrowable(failureMessage));
    }*/

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public Future<T> onComplete(Handler<AsyncResult<T>> handler) {
        if (handler instanceof Listener) {
            emitFailure(cause, (Listener<T>) handler);
        } /*else if (context != null) {
            context.emit(this, handler);
        }*/ else {
            handler.handle(this);
        }
        return this;
    }

    @Override
    public Future<T> onSuccess(Handler<T> handler) {
        return this;
    }

    @Override
    public Future<T> onFailure(Handler<Throwable> handler) {
        /*if (context != null) {
            context.emit(cause, handler);
        } else*/ {
            handler.handle(cause);
        }
        return this;
    }

    @Override
    public void addListener(Listener<T> listener) {
        emitFailure(cause, listener);
    }

    @Override
    public T result() {
        return null;
    }

    @Override
    public Throwable cause() {
        return cause;
    }

    @Override
    public boolean succeeded() {
        return false;
    }

    @Override
    public boolean failed() {
        return true;
    }

    @Override
    public <U> Future<U> map(Function<T, U> mapper) {
        return (Future<U>) this;
    }

    @Override
    public <V> Future<V> map(V value) {
        return (Future<V>) this;
    }

    @Override
    public Future<T> otherwise(T value) {
        return new SucceededFuture<>(/*context,*/ value);
    }

    @Override
    public String toString() {
        return "Future{cause=" + cause.getMessage() + "}";
    }
}
