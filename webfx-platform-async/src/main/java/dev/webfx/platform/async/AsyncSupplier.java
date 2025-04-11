package dev.webfx.platform.async;

import java.util.function.Supplier;

/**
 * A functional interface for asynchronous operations that take one argument and return a future result.
 *
 * @author Bruno Salmon
 */

@FunctionalInterface
public interface AsyncSupplier<R> extends Supplier<Future<R>> {

    @Override
    Future<R> get();

}
