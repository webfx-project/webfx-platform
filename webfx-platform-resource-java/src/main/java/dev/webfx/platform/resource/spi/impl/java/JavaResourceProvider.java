package dev.webfx.platform.resource.spi.impl.java;

import dev.webfx.platform.resource.spi.ResourceProvider;

import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Bruno Salmon
 */
public class JavaResourceProvider implements ResourceProvider {

    @Override
    public String toUrl(String resourcePath, Class<?> loadingClass) {
        if (resourcePath == null)
            return null;
        URL resource = null;
        if (loadingClass != null)
            resource = loadingClass.getResource(resourcePath); // if the resource is in the same module as the loading class
        if (resource == null) {
            String path = resourcePath.startsWith("/") ? resourcePath.substring(1) : resourcePath; // removing initial "/" (otherwise doesn't work)
            resource = ClassLoader.getSystemResource(path); // if the resource is in a different module
        }
        if (resource == null)
            throw new IllegalArgumentException("Resource not found: " + resourcePath);
        return resource.toExternalForm();
    }

    @Override
    public String getText(String resourcePath) {
        try (Scanner scanner = createScanner(getResourceInputStream(resourcePath))) {
            return scanner == null ? null : scanner.useDelimiter("\\A").next();
        }
    }

    private InputStream getResourceInputStream(String resourcePath) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath);
        if (inputStream == null) {
            try {
                inputStream = new URL(resourcePath).openStream();
            } catch (Exception e) {
            }
        }
        return inputStream;
    }

    private static Scanner createScanner(InputStream inputStream) {
        return inputStream == null ? null : new Scanner(inputStream, StandardCharsets.UTF_8);
    }
}
