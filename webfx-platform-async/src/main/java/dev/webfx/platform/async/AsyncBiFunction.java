package dev.webfx.platform.async;

import java.util.function.BiFunction;

/**
 * A functional interface for asynchronous operations that take two arguments and return a future result.
 *
 * @author Bruno Salmon
 */

public interface AsyncBiFunction<T,U,R> extends BiFunction<T, U, Future<R>> {

    Future<R> apply(T arg1, U arg2);

}
