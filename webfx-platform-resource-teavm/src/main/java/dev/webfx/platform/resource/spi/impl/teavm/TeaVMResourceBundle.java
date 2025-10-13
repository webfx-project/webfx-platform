package dev.webfx.platform.resource.spi.impl.teavm;

import dev.webfx.platform.resource.spi.impl.web.WebResourceBundleBase;
import dev.webfx.platform.resource.spi.impl.web.WebTextResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author Bruno Salmon
 */
public abstract class TeaVMResourceBundle extends WebResourceBundleBase {

    protected TeaVMResourceBundle(String... paths) {
        registerResources(paths);
    }

    protected void registerResources(String... paths) {
        for (String path : paths) {
            // Note: important to use `this.` to prevent runtime error (TeaVM bug).
            registerResource(path, () -> readTextResource(path));
        }
    }

    @Override
    protected void registerResource(String resourcePath, WebTextResource webTextResource) {
        super.registerResource(resourcePath, webTextResource);
    }

    protected static String readTextResource(String path) {
        if (!path.startsWith("/"))
            path = "/" + path;
        try (InputStream is = TeaVMResourceProvider.class.getResourceAsStream(path)) {
            if (is == null) {
                System.err.println("Resource not found: " + path);
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
            System.err.println("Exception: " + e.getMessage());
            return null;
        }
    }

}
