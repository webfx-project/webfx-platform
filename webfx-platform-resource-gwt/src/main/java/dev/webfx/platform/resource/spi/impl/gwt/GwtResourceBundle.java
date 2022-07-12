package dev.webfx.platform.resource.spi.impl.gwt;

import com.google.gwt.resources.client.TextResource;

/**
 * @author Bruno Salmon
 */
public interface GwtResourceBundle {

    TextResource getTextResource(String resourcePath);

    Iterable<String> resourcePathsForLogging();
}
