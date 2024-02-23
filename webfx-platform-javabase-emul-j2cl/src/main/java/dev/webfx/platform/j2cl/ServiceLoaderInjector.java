package dev.webfx.platform.j2cl;

import java.util.function.Function;
import java.util.function.Supplier;

public final class ServiceLoaderInjector {

    private static Function<Class, Supplier[]> serviceLoaderInjector;

    public static Function<Class, Supplier[]> getServiceLoaderInjector() {
        return serviceLoaderInjector;
    }

    public static void setServiceLoaderInjector(Function<Class, Supplier[]> serviceLoaderInjector) {
        ServiceLoaderInjector.serviceLoaderInjector = serviceLoaderInjector;
    }
}