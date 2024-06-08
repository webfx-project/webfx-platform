package dev.webfx.platform.vertx.common;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;

/**
 * @author Bruno Salmon
 */
public final class VertxFutureUtil {

    public static <T> Future<T> toWebFxFuture(io.vertx.core.Future<T> vertxFuture) {
        Promise<T> promise = Promise.promise();
        vertxFuture
                .onFailure(promise::fail)
                .onSuccess(promise::complete);
        return promise.future();
    }

    public static <T> io.vertx.core.Future<T> toVertxFuture(Future<T> vertxFuture) {
        io.vertx.core.Promise<T> promise = io.vertx.core.Promise.promise();
        vertxFuture
                .onFailure(promise::fail)
                .onSuccess(promise::complete);
        return promise.future();
    }

}
