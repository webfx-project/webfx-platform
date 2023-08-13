package dev.webfx.platform.util.serviceloader;

import dev.webfx.platform.util.collection.Collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.function.Supplier;

/**
 * Very simple utility class to get a list of providers. Its main benefit is that it keeps those lists in memory, so it
 * will always return the same lists of unique providers instances, without instantiating them again on subsequent calls.
 * This would not be the case with the standard ServiceLoader, which creates new providers instances on each call.
 * So this utility class can be useful for pieces of code that need to refer to a list of providers several times, with
 * the guarantee to have the same unique instances each time. By using this utility class, you spare the declaration
 * of a field for storing your providers, and it can therefore be used even in interface default methods.
 *
 * Typical usage: {@code
 *
 *     private static List<MyProvider> getMyProviders() {
 *         return MultipleServiceProviders.getProviders(MyProvider.class, () -> ServiceLoader.load(MyProvider.class));
 *     }
 *}
 * Note: the reason why ServiceLoader.load() is written in the caller code and not in this utility class is to be
 * compliant with the Java Platform Module System. The caller module has to declare in module-info.java that it's using
 * this service, and only the caller code can ask the ServiceLoader to load this service, this utility class can't.
 *
 * @author Bruno Salmon
 */
public final class MultipleServiceProviders {

    private final static Map<Class<?>, List<?>> PROVIDERS_MAP = new HashMap<>();
    public static <S> List<S> getProviders(Class<S> serviceClass, Supplier<ServiceLoader<S>> serviceLoaderSupplier) {
        List<S> providers = (List<S>) PROVIDERS_MAP.get(serviceClass);
        if (providers == null)
            PROVIDERS_MAP.put(serviceClass, providers = Collections.listOf(serviceLoaderSupplier.get()));
        return providers;
    }

}
