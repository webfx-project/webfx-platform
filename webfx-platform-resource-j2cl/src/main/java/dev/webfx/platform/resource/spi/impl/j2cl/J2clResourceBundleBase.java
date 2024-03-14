package dev.webfx.platform.resource.spi.impl.j2cl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public abstract class J2clResourceBundleBase implements J2clResourceBundle {

    private final Map<String, TextResource> resources = new HashMap<>();

    protected void registerResource(String resourcePath, TextResource textResource) {
        resources.put(resourcePath, textResource);
    }

    @Override
    public TextResource getTextResource(String resourcePath) {
        return resources.get(resourcePath);
    }

    @Override
    public Iterable<String> resourcePathsForLogging() {
        return resources.keySet();
    }
}
