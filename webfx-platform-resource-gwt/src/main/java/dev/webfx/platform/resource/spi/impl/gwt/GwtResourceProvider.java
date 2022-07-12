package dev.webfx.platform.resource.spi.impl.gwt;

import com.google.gwt.resources.client.TextResource;
import dev.webfx.platform.resource.spi.ResourceProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Salmon
 */
public final class GwtResourceProvider implements ResourceProvider {

    private final List<GwtResourceBundle> bundles = new ArrayList<>();

    public void register(GwtResourceBundle bundle) {
        bundles.add(bundle);
    }

    @Override
    public String toUrl(String resourcePath, Class<?> loadingClass) {
        if (resourcePath != null) {
            if (resourcePath.startsWith("/"))
                resourcePath = resourcePath.substring(1);
            else {
                String className = loadingClass.getName();
                resourcePath = className.replace(".", "/").substring(0, className.length() - loadingClass.getSimpleName().length()) + resourcePath;
            }
        }
        return resourcePath;
    }

    @Override
    public String getText(String resourcePath) {
        for (GwtResourceBundle bundle : bundles) {
            TextResource textResource = bundle.getTextResource(resourcePath);
            if (textResource != null)
                return textResource.getText();
        }
        return null;
    }
}
