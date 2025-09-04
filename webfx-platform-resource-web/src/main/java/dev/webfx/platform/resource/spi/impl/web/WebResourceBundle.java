package dev.webfx.platform.resource.spi.impl.web;

/**
 * @author Bruno Salmon
 */
public interface WebResourceBundle {

    WebTextResource getTextResource(String resourcePath);

    Iterable<String> resourcePathsForLogging();
}
