package dev.webfx.platform.resource.spi.impl.java;

import dev.webfx.platform.resource.spi.ResourceProvider;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Bruno Salmon
 */
public final class JavaResourceProvider implements ResourceProvider {

    @Override
    public String toUrl(String resourcePath, Class<?> loadingClass) {
        return loadingClass.getResource(resourcePath).toExternalForm();
    }

    @Override
    public String getText(String resourcePath) {
        try (Scanner scanner = createScanner(getClass().getClassLoader().getResourceAsStream(resourcePath))) {
            return scanner == null ? null : scanner.useDelimiter("\\A").next();
        }
    }

    private static Scanner createScanner(InputStream inputStream) {
        return inputStream == null ? null : new Scanner(inputStream, "UTF-8");
    }
}
