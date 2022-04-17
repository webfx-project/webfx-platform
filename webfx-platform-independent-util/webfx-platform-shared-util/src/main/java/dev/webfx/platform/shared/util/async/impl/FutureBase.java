package dev.webfx.platform.shared.util.async.impl;

import dev.webfx.platform.shared.util.async.AsyncResult;
import dev.webfx.platform.shared.util.async.Future;

import java.util.Objects;
import java.util.function.Function;

// Async API inspired from Vert.x (simplified, without Vert.x context and Netty dependency)

/**
 * Future base implementation.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
abstract class FutureBase<T> implements FutureInternal<T> {

    //protected final ContextInternal context;

    /**
     * Create a future that hasn't completed yet
     */
    /*FutureBase() {
        this(null);
    }*/

    /**
     * Create a future that hasn't completed yet
     */
    /*FutureBase(ContextInternal context) {
        this.context = context;
    }*/

    /*public final ContextInternal context() {
        return context;
    }*/

    protected final void emitSuccess(T value, Listener<T> listener) {
        /*if (context != null && !context.isRunningOnContext()) {
            context.execute(() -> {
                ContextInternal prev = context.beginDispatch();
                try {
                    listener.onSuccess(value);
                } finally {
                    context.endDispatch(prev);
                }
            });
        } else {*/
            listener.onSuccess(value);
        //}
    }

    protected final void emitFailure(Throwable cause, Listener<T> listener) {
        /*if (context != null && !context.isRunningOnContext()) {
            context.execute(() -> {
                ContextInternal prev = context.beginDispatch();
                try {
                    listener.onFailure(cause);
                } finally {
                    context.endDispatch(prev);
                }
            });
        } else {*/
            listener.onFailure(cause);
        //}
    }

    @Override
    public <U> Future<U> compose(Function<T, Future<U>> successMapper, Function<Throwable, Future<U>> failureMapper) {
        Objects.requireNonNull(successMapper, "No null success mapper accepted");
        Objects.requireNonNull(failureMapper, "No null failure mapper accepted");
        Composition<T, U> operation = new Composition<>(/*context,*/ successMapper, failureMapper);
        addListener(operation);
        return operation;
    }

    @Override
    public <U> Future<U> transform(Function<AsyncResult<T>, Future<U>> mapper) {
        Objects.requireNonNull(mapper, "No null mapper accepted");
        Transformation<T, U> operation = new Transformation<>(/*context,*/ this, mapper);
        addListener(operation);
        return operation;
    }

    @Override
    public <U> Future<T> eventually(Function<Void, Future<U>> mapper) {
        Objects.requireNonNull(mapper, "No null mapper accepted");
        Eventually<T, U> operation = new Eventually<>(/*context,*/ mapper);
        addListener(operation);
        return operation;
    }

    @Override
    public <U> Future<U> map(Function<T, U> mapper) {
        Objects.requireNonNull(mapper, "No null mapper accepted");
        Mapping<T, U> operation = new Mapping<>(/*context,*/ mapper);
        addListener(operation);
        return operation;
    }

    @Override
    public <V> Future<V> map(V value) {
        FixedMapping<T, V> transformation = new FixedMapping<>(/*context,*/ value);
        addListener(transformation);
        return transformation;
    }

    @Override
    public Future<T> otherwise(Function<Throwable, T> mapper) {
        Objects.requireNonNull(mapper, "No null mapper accepted");
        Otherwise<T> transformation = new Otherwise<>(/*context,*/ mapper);
        addListener(transformation);
        return transformation;
    }

    @Override
    public Future<T> otherwise(T value) {
        FixedOtherwise<T> operation = new FixedOtherwise<>(/*context,*/ value);
        addListener(operation);
        return operation;
    }
}
