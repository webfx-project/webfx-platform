package dev.webfx.platform.util.elemental2.async;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import java.util.function.Function;

/**
 * @author Bruno Salmon
 */
public class Elemental2Async {

    public static <J, T> Future<T> jsPromiseToWebFXFuture(elemental2.promise.Promise<J> jsPromise, Function<J, T> onSuccessFunction) {
        Promise<T> promise = Promise.promise();
        // Not sure about if then() and catch() are exclusive so using tryComplete() and tryFail() to avoid additional exceptions
        jsPromise
                .then(obj -> {
                    promise.tryComplete(onSuccessFunction.apply(obj));
                    return null;
                })
                .catch_(error -> {
                    if (error instanceof Throwable)
                        promise.tryFail((Throwable) error);
                    else
                        promise.tryFail(error.toString());
                    return null;
                });
        return promise.future();
    }

}
