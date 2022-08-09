package dev.webfx.stack.async;


import dev.webfx.stack.async.impl.NoStackTraceThrowable;
import dev.webfx.stack.async.impl.PromiseImpl;

// Async API inspired from Vert.x (simplified, without Vert.x context and Netty dependency)

/**
 * Represents the writable side of an action that may, or may not, have occurred yet.
 * <p>
 * The {@link #future()} method returns the {@link Future} associated with a promise, the future
 * can be used for getting notified of the promise completion and retrieve its value.
 * <p>
 * A promise extends {@code Handler<AsyncResult<T>>} so it can be used as a callback.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
//@VertxGen
public interface Promise<T> extends Handler<AsyncResult<T>> {

    /**
     * Create a promise that hasn't completed yet
     *
     * @param <T>  the result type
     * @return  the promise
     */
    static <T> Promise<T> promise() {
        return new PromiseImpl<>();
    }

    /**
     * Succeed or fail this promise with the {@link AsyncResult} event.
     *
     * @param asyncResult the async result to handle
     */
    //@GenIgnore
    @Override
    default void handle(AsyncResult<T> asyncResult) {
        if (asyncResult.succeeded()) {
            complete(asyncResult.result());
        } else {
            fail(asyncResult.cause());
        }
    }

    /**
     * Set the result. Any handler will be called, if there is one, and the promise will be marked as completed.
     * <p/>
     * Any handler set on the associated promise will be called.
     *
     * @param result  the result
     * @throws IllegalStateException when the promise is already completed
     */
    default void complete(T result) {
        if (!tryComplete(result)) {
            throw new IllegalStateException("Result is already complete");
        }
    }

    /**
     * Calls {@code complete(null)}
     *
     * @throws IllegalStateException when the promise is already completed
     */
    default void complete() {
        if (!tryComplete()) {
            throw new IllegalStateException("Result is already complete");
        }
    }

    /**
     * Set the failure. Any handler will be called, if there is one, and the future will be marked as completed.
     *
     * @param cause  the failure cause
     * @throws IllegalStateException when the promise is already completed
     */
    default void fail(Throwable cause) {
        if (!tryFail(cause)) {
            throw new IllegalStateException("Result is already complete");
        }
    }

    /**
     * Calls {@link #fail(Throwable)} with the {@code message}.
     *
     * @param message  the failure message
     * @throws IllegalStateException when the promise is already completed
     */
    default void fail(String message) {
        if (!tryFail(message)) {
            throw new IllegalStateException("Result is already complete");
        }
    }

    /**
     * Like {@link #complete(Object)} but returns {@code false} when the promise is already completed instead of throwing
     * an {@link IllegalStateException}, it returns {@code true} otherwise.
     *
     * @param result  the result
     * @return {@code false} when the future is already completed
     */
    boolean tryComplete(T result);

    /**
     * Calls {@code tryComplete(null)}.
     *
     * @return {@code false} when the future is already completed
     */
    default boolean tryComplete() {
        return tryComplete(null);
    }

    /**
     * Like {@link #fail(Throwable)} but returns {@code false} when the promise is already completed instead of throwing
     * an {@link IllegalStateException}, it returns {@code true} otherwise.
     *
     * @param cause  the failure cause
     * @return {@code false} when the future is already completed
     */
    boolean tryFail(Throwable cause);

    /**
     * Calls {@link #fail(Throwable)} with the {@code message}.
     *
     * @param message  the failure message
     * @return false when the future is already completed
     */
    default boolean tryFail(String message) {
        return tryFail(new NoStackTraceThrowable(message));
    }

    /**
     * @return the {@link Future} associated with this promise, it can be used to be aware of the promise completion
     */
    //@CacheReturn
    Future<T> future();

}
