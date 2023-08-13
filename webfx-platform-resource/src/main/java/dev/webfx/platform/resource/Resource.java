package dev.webfx.platform.resource;

import dev.webfx.platform.resource.spi.ResourceProvider;
import dev.webfx.platform.util.serviceloader.SingleServiceProvider;

import java.util.ServiceLoader;
import java.util.function.Consumer;

/**
 * @author Bruno Salmon
 */
public final class Resource {

    private Resource() {}

    private static ResourceProvider PROVIDER;

    public static ResourceProvider getProvider() {
        if (PROVIDER == null)
            registerProvider(SingleServiceProvider.getProvider(ResourceProvider.class, () -> ServiceLoader.load(ResourceProvider.class)));
        return PROVIDER;
    }

    public static void registerProvider(ResourceProvider provider) {
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
