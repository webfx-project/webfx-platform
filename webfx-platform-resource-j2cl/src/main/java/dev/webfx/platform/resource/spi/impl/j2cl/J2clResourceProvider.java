package dev.webfx.platform.resource.spi.impl.j2cl;

import dev.webfx.platform.resource.spi.ResourceProvider;
import elemental2.dom.DomGlobal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Bruno Salmon
 */
public final class J2clResourceProvider implements ResourceProvider {

    private final List<J2clResourceBundle> bundles = new ArrayList<>();

    public void register(J2clResourceBundle bundle) {
        bundles.add(bundle);
    }

    @Override
    public String toUrl(String resourcePath, Class<?> loadingClass) {
        if (resourcePath != null) {
            // If the resource path is already an absolute URL, we return it as is
            if (resourcePath.contains("://")) // ex: https://, http://, file://, etc.
                return resourcePath;
            // We need to return the absolute path of the resource from index.html file (the resource packages are located beside index.html)
            if (resourcePath.startsWith("/")) // If the path provided is already absolute,
                resourcePath = resourcePath.substring(1); // we just remove the first / to make that path relative to index.html
            else if (loadingClass != null) { // If the path is relative to the loading class,
                // We need to prefix the path with the location of the package at the same level of the loadingClass
                // Getting the class package name
                String fullClassName = loadingClass.getName(); // GWT doesn't support Class.getPackageName() so we get the fully qualified class name
                String packageName = fullClassName.substring(0, fullClassName.length() - loadingClass.getSimpleName().length() - 1); // and remove the class name as well as the last '.'
                // We replace all the '.' with '/' and append the relative resource path
                resourcePath = packageName.replace('.', '/') + "/" + resourcePath;
            }
        }
        return resourcePath;
    }

    @Override
    public String getText(String resourcePath) {
        for (J2clResourceBundle bundle : bundles) {
            TextResource textResource = bundle.getTextResource(resourcePath);
            if (textResource != null)
                return textResource.getText();
        }
        return null;
    }

    @Override
    public void loadText(String resourcePath, Consumer<String> onSuccess, Consumer<Throwable> onFailure) {
        // Maybe the resource is embedded in a GWT bundle?
        String text = getText(resourcePath); // let's try
        if (text != null) // Yes it was!
            onSuccess.accept(text);
        else { // No it wasn't, so it's a remote file that we need to fetch
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
