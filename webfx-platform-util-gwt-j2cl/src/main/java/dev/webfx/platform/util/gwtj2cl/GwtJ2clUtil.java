package dev.webfx.platform.util.gwtj2cl;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import elemental2.core.JsIIterableResult;
import elemental2.core.JsIterator;

import java.util.Iterator;
import java.util.function.Function;

/**
 * @author Bruno Salmon
 */
public final class GwtJ2clUtil {

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

    public static <T> Iterator<T> jsIteratorToJavaIterator(JsIterator<T, ?, ?> jsIterator) {
        return new Iterator<>() {
            private JsIIterableResult<T> next = jsIterator.next();

            @Override
            public boolean hasNext() {
                return !next.isDone();
            }

            @Override
            public T next() {
                T value = next.getValue();
                next = jsIterator.next();
                return value;
            }
        };
    }

}
