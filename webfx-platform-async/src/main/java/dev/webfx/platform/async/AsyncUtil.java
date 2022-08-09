package dev.webfx.platform.async;

import dev.webfx.platform.util.tuples.Unit;

import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bruno Salmon
 */
public final class AsyncUtil {

    /**
     * Wrap a runnable into a future that complete immediately or fail if an exception is thrown.
     *
     * @param runnable  the runnable
     * @return  the future
     */
    public static <R> Future<R> runAsync(Runnable runnable) {
        try {
            runnable.run();
            return Future.succeededFuture();
        } catch (Throwable t) {
            // temporary tracing the exception while exception handling mechanism is not finished
            Logger.getGlobal().log(Level.SEVERE, "Exception raised in Future.runAsync()", t);
            return Future.failedFuture(t);
        }
    }

    /**
     * Wrap a consumer into a future that complete immediately or fail if an exception is thrown.
     *
     * @param consumer  the consumer
     * @param arg  the argument to pass to the consumer
     * @param <T>  the argument type
     * @return  the future
     */
    public static <T,R> Future<R> consumeAsync(Consumer<T> consumer, T arg) {
        try {
            consumer.accept(arg);
            return Future.succeededFuture();
        } catch (Throwable t) {
            // temporary tracing the exception while exception handling mechanism is not finished
            Logger.getGlobal().log(Level.SEVERE, "Exception raised in Future.consumeAsync()", t);
            return Future.failedFuture(t);
        }
    }

    public static Future<Void> allOf(Future... futures) {
        Promise<Void> promise = Promise.promise();
        Unit<Integer> latch = new Unit<>(futures.length);
        Handler<AsyncResult> latchHandler = asyncResult -> {
            if (asyncResult.failed())
                promise.fail(asyncResult.cause());
            else synchronized (latch) {
                Integer count;
                latch.set(count = latch.get() - 1);
                if (count == 0)
                    promise.complete();
            }
        };
        for (Future f : futures)
            f.onComplete(latchHandler);
        return promise.future();
    }

}
