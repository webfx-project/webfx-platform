// File managed by WebFX (DO NOT EDIT MANUALLY)
package java.util;

import dev.webfx.platform.javabase.emul.j2cl.ServiceRegistry;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.Iterator;
import java.util.logging.Logger;

public final class ServiceLoader<S> implements Iterable<S> {

    public static <S> ServiceLoader<S> load(Class<S> serviceClass) {
        Supplier<S>[] factories = ServiceRegistry.getProviderFactories(serviceClass);
        if (factories == null) {
            // Add log
            factories = new Supplier[] {};
        }
        return new ServiceLoader<S>(factories);
    }

    private final Supplier<S>[] factories;

    public ServiceLoader(Supplier<S>[] factories) {
        this.factories = factories;
    }

    public Iterator<S> iterator() {
        return new Iterator<S>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < factories.length;
            }

            @Override
            public S next() {
                return (S) factories[index++].get();
            }
        };
    }
}