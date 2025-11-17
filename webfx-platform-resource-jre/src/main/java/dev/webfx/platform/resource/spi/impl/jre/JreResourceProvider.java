package dev.webfx.platform.resource.spi.impl.jre;

import dev.webfx.platform.resource.spi.ResourceProvider;

import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Bruno Salmon
 */
public class JreResourceProvider implements ResourceProvider {

    @Override
    public String toUrl(String resourcePath, Class<?> loadingClass) {
        if (resourcePath == null)
            return null;
        // If the resource path is already an absolute URL, we return it as is
        if (resourcePath.contains("://")) // ex: https://, http://, file://, etc.
            return resourcePath;
        URL resource = null;
        if (loadingClass != null) {
            resource = loadingClass.getResource(resourcePath); // if the resource is in the same module as the loading class
            if (resource == null && !resourcePath.startsWith("/")) {
                resourcePath = "/" + loadingClass.getPackageName().replace('.', '/') + "/" + resourcePath;
                resource = loadingClass.getResource(resourcePath);
            }
        }
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
        if (resourcePath == null || resourcePath.isEmpty()) {
            return null;
        }

        // 1) If the path looks like a URL, use URL.openStream() directly
        //    (file:, http:, https:, jar:, etc.)
        if (resourcePath.contains("://") || resourcePath.startsWith("file:")) {
            try {
                return new URL(resourcePath).openStream();
            } catch (Exception e) {
                // fall through and try other strategies
            }
        }

        // 2) If the path looks like a Windows absolute path (e.g. C:\dir\file.txt),
        //    treat it as a file on disk.
        if (resourcePath.matches("^[a-zA-Z]:\\\\.*")) {
            try {
                return new java.io.FileInputStream(resourcePath);
            } catch (Exception e) {
                // fall through and try classpath lookups
            }
        }

        // 3) Classpath resource lookup: use '/' separators
        String classpathName = resourcePath.replace('\\', '/');

        // First try with this class's classloader
        ClassLoader cl = getClass().getClassLoader();
        InputStream inputStream = cl.getResourceAsStream(classpathName);
        if (inputStream != null) {
            return inputStream;
        }

        // Also try system classloader in case resource is there
        inputStream = ClassLoader.getSystemResourceAsStream(
                classpathName.startsWith("/") ? classpathName.substring(1) : classpathName
        );
        if (inputStream != null) {
            return inputStream;
        }

        // Nothing worked
        return null;
    }

    private static Scanner createScanner(InputStream inputStream) {
        return inputStream == null ? null : new Scanner(inputStream, StandardCharsets.UTF_8);
    }
}
