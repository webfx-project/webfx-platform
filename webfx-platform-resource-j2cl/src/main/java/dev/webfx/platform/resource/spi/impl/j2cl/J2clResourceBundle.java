package dev.webfx.platform.resource.spi.impl.j2cl;

/**
 * @author Bruno Salmon
 */
public interface J2clResourceBundle {

    TextResource getTextResource(String resourcePath);

    Iterable<String> resourcePathsForLogging();
}
