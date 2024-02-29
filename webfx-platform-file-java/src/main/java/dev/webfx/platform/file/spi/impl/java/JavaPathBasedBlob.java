package dev.webfx.platform.file.spi.impl.java;

import dev.webfx.platform.blob.spi.impl.java.JavaBlob;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Bruno Salmon
 */
public abstract class JavaPathBasedBlob extends JavaBlob {

    public JavaPathBasedBlob(Object platformBlob) {
        super(platformBlob);
    }

    protected abstract Path toPath();

    public String getMimeType() {
        try {
            return Files.probeContentType(toPath());
        } catch (IOException e) {
            return null;
        }
    }

}
