package dev.webfx.platform.file.spi.impl.java;

import dev.webfx.platform.blob.spi.impl.java.JavaBlob;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Bruno Salmon
 */
public abstract class JavaPathBasedBlob extends JavaBlob {

    private String mimeType;

    public JavaPathBasedBlob(Object platformBlob) {
        this(platformBlob, null);
    }

    public JavaPathBasedBlob(Object platformBlob, String mimeType) {
        super(platformBlob);
        this.mimeType = mimeType;
    }

    protected abstract Path toPath();

    public String getMimeType() {
        if (mimeType == null) {
            try {
                mimeType = Files.probeContentType(toPath());
            } catch (IOException ignored) { }
        }
        return mimeType;
    }

}
