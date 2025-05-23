package dev.webfx.platform.async;

import java.util.function.Function;

/**
 * A functional interface for asynchronous operations that take one argument and return a future result.
 *
 * @author Bruno Salmon
 */

@FunctionalInterface
public interface AsyncFunction<A,R> extends Function<A, Future<R>> {

    @Override
    Future<R> apply(A arg);

}
