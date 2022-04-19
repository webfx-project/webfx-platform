package dev.webfx.platform.shared.services.resource.spi;

import java.util.function.Consumer;

/**
 * @author Bruno Salmon
 */
public interface ResourceServiceProvider {

    String toUrl(String resourcePath, Class<?> loadingClass);

    String getText(String resourcePath);

    default void loadText(String resourcePath, Consumer<String> onSuccess, Consumer<Throwable> onFailure) {
        onSuccess.accept(getText(resourcePath));
    }

}
