package dev.webfx.platform.shared.services.resource;

import dev.webfx.platform.shared.services.resource.spi.ResourceServiceProvider;
import dev.webfx.platform.shared.util.serviceloader.SingleServiceProvider;

import java.util.ServiceLoader;
import java.util.function.Consumer;

/**
 * @author Bruno Salmon
 */
public final class ResourceService {

    private static ResourceServiceProvider PROVIDER;

    public static ResourceServiceProvider getProvider() {
        if (PROVIDER == null)
            registerProvider(SingleServiceProvider.getProvider(ResourceServiceProvider.class, () -> ServiceLoader.load(ResourceServiceProvider.class)));
        return PROVIDER;
    }

    public static void registerProvider(ResourceServiceProvider provider) {
        PROVIDER = provider;
    }

    public static String toUrl(String resourcePath, Class<?> loadingClass) {
        return getProvider().toUrl(resourcePath, loadingClass);
    }

    public static String getText(String resourcePath) {
        return getProvider().getText(resourcePath);
    }

    public static void loadText(String resourcePath, Consumer<String> onSuccess, Consumer<Throwable> onFailure) {
        getProvider().loadText(resourcePath, onSuccess, onFailure);
    }
}
