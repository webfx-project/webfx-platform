package dev.webfx.platform.javabase.emul.j2cl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author Bruno Salmon
 */
public final class ServiceRegistry {

    private static final Map<Class, Supplier[]> PROVIDER_FACTORIES = new HashMap<>();

    public static <S> void register(Class<S> serviceClass, Supplier<S>... providerFactories) {
        PROVIDER_FACTORIES.put(serviceClass, providerFactories);
    }

    public static <S> Supplier<S>[] getProviderFactories(Class<S> serviceClass) {
        return (Supplier<S>[]) PROVIDER_FACTORIES.get(serviceClass);
    }

}
