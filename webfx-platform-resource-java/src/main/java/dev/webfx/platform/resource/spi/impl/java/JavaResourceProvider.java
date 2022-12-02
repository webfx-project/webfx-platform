package dev.webfx.platform.resource.spi.impl.java;

import dev.webfx.platform.resource.spi.ResourceProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Bruno Salmon
 */
public final class JavaResourceProvider implements ResourceProvider {

    @Override
    public String toUrl(String resourcePath, Class<?> loadingClass) {
        if (resourcePath == null)
            return null;
        URL resource = loadingClass.getResource(resourcePath);
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
        if (inputStream == null && resourcePath.startsWith("file:"))
            try {
                inputStream = new FileInputStream(resourcePath.substring(5));
            } catch (FileNotFoundException e) { }
        return inputStream;
    }

    private static Scanner createScanner(InputStream inputStream) {
        return inputStream == null ? null : new Scanner(inputStream, StandardCharsets.UTF_8);
    }
}
