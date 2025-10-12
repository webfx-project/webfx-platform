package dev.webfx.platform.resource.spi.impl.jre;

import dev.webfx.platform.resource.spi.ResourceProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

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
/* Modern code but doesn't compile with TeaVM (TeaVMResourceProvider extends this class), so we use the old-style code.
        try (Scanner scanner = createScanner(getResourceInputStream(resourcePath))) {
            return scanner == null ? null : scanner.useDelimiter("\\A").next();
        }
*/
        try (InputStream is = getResourceInputStream(resourcePath)) {
            if (is == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!sb.isEmpty()) {
                        sb.append('\n');
                    }
                    sb.append(line);
                }
            }
            return sb.toString();
        } catch (IOException e) {
            return null;
        }
    }

    private InputStream getResourceInputStream(String resourcePath) {
        InputStream inputStream = null;
        try {
            // trying directly with the provided resourcePath
            // Note: this may fail if resourcePath is actually a URL path such as file:/... => raises an exception on
            // Windows, but just returns null on other platforms
            inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath);
        } catch (Exception ignored) { }
        if (inputStream == null) {
            try {
                // Now trying with a URL path
                inputStream = new URL(resourcePath).openStream();
            } catch (Exception ignored) { }
        }
        return inputStream;
    }

    /* Not used anymore due to TeaVM incompatibility
    private static Scanner createScanner(InputStream inputStream) {
        return inputStream == null ? null : new Scanner(inputStream, StandardCharsets.UTF_8);
    }*/
}
