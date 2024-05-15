package dev.webfx.platform.async;

import dev.webfx.platform.util.tuples.Unit;

import java.util.function.IntFunction;

/**
 * @author Bruno Salmon
 */
public final class Batch<A> {

    private final A[] array;

    public Batch(A[] array) {
        this.array = array;
    }

    public A[] getArray() {
        return array;
    }

    public A get(int index) {
        return array[index];
    }

    public <R> Future<Batch<R>> executeParallel(IntFunction<R[]> arrayGenerator, AsyncFunction<A, R> asyncFunction) {
        return executeParallel(Promise.promise(), arrayGenerator, asyncFunction);
    }

    public <R> Future<Batch<R>> executeParallel(Promise<Batch<R>> promise, IntFunction<R[]> arrayGenerator, AsyncFunction<A, R> asyncFunction) {
        int n = array.length, i = 0;
        R[] results = arrayGenerator.apply(n);
        Batch<R> resultsBatch = new Batch<>(results);
        if (n == 0)
            return Future.succeededFuture(resultsBatch);
        Unit<Integer> responseCounter = new Unit<>(0);
        for (A argument : getArray()) {
            int index = i++;
            asyncFunction.apply(argument).onComplete(asyncResult -> {
                if (!promise.future().isComplete()) {
                    if (asyncResult.failed())
                        promise.fail(asyncResult.cause());
                    else {
                        results[index] = asyncResult.result();
                        responseCounter.set(responseCounter.get() + 1);
                        if (responseCounter.get() == n)
                            promise.complete(resultsBatch);
                    }
                }
            });
        }
        return promise.future();
    }

    public <R> Future<Batch<R>> executeSerial(IntFunction<R[]> arrayGenerator, AsyncFunction<A, R> asyncFunction) {
        return executeSerial(Promise.promise(), arrayGenerator, asyncFunction);
    }

    public <R> Future<Batch<R>> executeSerial(Promise<Batch<R>> promise, IntFunction<R[]> arrayGenerator, AsyncFunction<A, R> asyncFunction) {
        int n = array.length;
        R[] results = arrayGenerator.apply(n);
        Batch<R> resultsBatch = new Batch<>(results);
        if (n == 0)
            return Future.succeededFuture(resultsBatch);
        Unit<Integer> responseCounter = new Unit<>(0);
        Unit<Handler<AsyncResult<R>>> handlerUnit = new Unit<>();
        handlerUnit.set(asyncResult -> {
            if (!promise.future().isComplete()) {
                if (asyncResult.failed())
                    promise.fail(asyncResult.cause());
                else {
                    int count = responseCounter.get();
                    results[count] = asyncResult.result();
                    responseCounter.set(++count);
                    if (count < n)
                        asyncFunction.apply(getArray()[count]).onComplete(handlerUnit.get());
                    else
                        promise.complete(resultsBatch);
                }
            }
        });
        asyncFunction.apply(getArray()[0]).onComplete(handlerUnit.get());
        return promise.future();
    }

    public <R> Future<Batch<R>> executeIfSingularBatch(IntFunction<R[]> arrayGenerator, AsyncFunction<A, R> asyncFunction) {
        if (array.length > 1)
            return null;
        Promise<Batch<R>> promise = Promise.promise();
        executeIfSingularBatch(promise, arrayGenerator, asyncFunction);
        return promise.future();
    }

    public <R> boolean executeIfSingularBatch(Promise<Batch<R>> promise, IntFunction<R[]> arrayGenerator, AsyncFunction<A, R> asyncFunction) {
        int n = array.length;
        if (n > 1)
            return false;
        R[] results = arrayGenerator.apply(n);
        if (n == 0)
            promise.complete(new Batch<>(results));
        else
            asyncFunction.apply(array[0]).onComplete(asyncResult -> {
                if (!promise.future().isComplete()) {
                    if (asyncResult.failed())
                        promise.fail(asyncResult.cause());
                    else {
                        results[0] = asyncResult.result();
                        promise.complete(new Batch<>(results));
                    }
                }
            });
        return true;
    }
}