package dev.webfx.platform.resource.spi.impl.elemental2;

import dev.webfx.platform.polyfillcompat.PolyfillCompat;
import dev.webfx.platform.resource.spi.impl.web.WebResourceProvider;
import elemental2.dom.DomGlobal;

import java.util.function.Consumer;

/**
 * @author Bruno Salmon
 */
public final class Elemental2ResourceProvider extends WebResourceProvider {

    @Override
    protected void fetchText(String resourcePath, Consumer<String> onSuccess, Consumer<Throwable> onFailure) {
        DomGlobal.window.fetch(resourcePath)
            .then(response -> {
                if (!PolyfillCompat.getResponseOk(response)) {
                    reportFetchError(resourcePath, PolyfillCompat.getResponseStatusText(response), onFailure);
                } else
                    response.text().then(text1 -> {
                        onSuccess.accept(text1);
                        return null;
                    }).catch_(error -> {
                        reportFetchError(resourcePath, error, onFailure);
                        return null;
                    });
                return null;
            })
            .catch_(error -> {
                reportFetchError(resourcePath, error, onFailure);
                return null;
            });
    }

    private void reportFetchError(String resourcePath, Object error, Consumer<Throwable> onFailure) {
        if (error instanceof Throwable)
            onFailure.accept((Throwable) error);
        else
            onFailure.accept(new RuntimeException("Error while fetching '" + resourcePath + "': " + error));
    }
}
