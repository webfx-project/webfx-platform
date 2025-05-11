package dev.webfx.platform.resource.spi.impl.gwtj2cl;

import dev.webfx.platform.resource.spi.impl.web.WebResourceProvider;
import elemental2.dom.DomGlobal;

import java.util.function.Consumer;

/**
 * @author Bruno Salmon
 */
public final class GwtJ2clResourceProvider extends WebResourceProvider {

    @Override
    public void loadText(String resourcePath, Consumer<String> onSuccess, Consumer<Throwable> onFailure) {
        // Maybe the resource is embedded in a GWT bundle?
        String text = getText(resourcePath); // let's try
        if (text != null) // Yes it was!
            onSuccess.accept(text);
        else { // No, it wasn't, so it's a remote file that we need to fetch
            DomGlobal.window.fetch(resourcePath)
                    .then(response -> {
                        if (!response.ok) {
                            reportFetchError(resourcePath, response.statusText, onFailure);
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
                    })
            ;
        }
    }

    private void reportFetchError(String resourcePath, Object error, Consumer<Throwable> onFailure) {
        if (error instanceof Throwable)
            onFailure.accept((Throwable) error);
        else
            onFailure.accept(new RuntimeException("Error while fetching '" + resourcePath + "': " + error));
    }
}
