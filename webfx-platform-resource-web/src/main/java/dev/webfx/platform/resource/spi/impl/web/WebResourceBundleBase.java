package dev.webfx.platform.resource.spi.impl.web;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public abstract class WebResourceBundleBase implements WebResourceBundle {

    private final Map<String, WebTextResource> resources = new HashMap<>();

    protected void registerResource(String resourcePath, WebTextResource webTextResource) {
        resources.put(resourcePath, webTextResource);
    }

    @Override
    public WebTextResource getTextResource(String resourcePath) {
        return resources.get(resourcePath);
    }

    @Override
    public Iterable<String> resourcePathsForLogging() {
        return resources.keySet();
    }
}
