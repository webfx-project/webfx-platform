package dev.webfx.platform.fetch.spi.impl.gwt;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import elemental2.core.JsIIterableResult;
import elemental2.core.JsIterator;

import java.util.Iterator;
import java.util.function.Function;

/**
 * @author Bruno Salmon
 */
final class GwtUtil {

    static <J, T> Future<T> jsPromiseToWebFXFuture(elemental2.promise.Promise<J> jsPromise, Function<J, T> onSuccessFunction) {
        Promise<T> promise = Promise.promise();
        jsPromise
                .then(obj -> {
                    promise.complete(onSuccessFunction.apply(obj));
                    return null;
                })
                .catch_(error -> {
                    if (error instanceof Throwable)
                        promise.fail((Throwable) error);
                    else
                        promise.fail(error.toString());
                    return null;
                });
        return promise.future();
    }

    static <T> Iterator<T> jsIteratorToJavaIterator(JsIterator<T, ?, ?> jsIterator) {
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
