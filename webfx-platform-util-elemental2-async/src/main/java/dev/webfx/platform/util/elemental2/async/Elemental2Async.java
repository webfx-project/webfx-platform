package dev.webfx.platform.util.elemental2.async;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;

/**
 * @author Bruno Salmon
 */
public class Elemental2Async {

    public static <T> Future<T> jsPromiseToWebFXFuture(elemental2.promise.Promise<T> jsPromise) {
        Promise<T> p = Promise.promise();
        jsPromise
            .then(obj -> {
                p.tryComplete(obj);
                return null;
            })
            .catch_(error -> {
                if (error instanceof Throwable)
                    p.tryFail((Throwable) error);
                else
                    p.tryFail(error.toString());
                return null;
            });
        return p.future();
    }


}
