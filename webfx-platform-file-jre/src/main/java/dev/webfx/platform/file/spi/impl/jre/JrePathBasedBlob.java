package dev.webfx.platform.file.spi.impl.jre;

import dev.webfx.platform.blob.spi.impl.jre.JreBlob;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Bruno Salmon
 */
public abstract class JrePathBasedBlob extends JreBlob {

    private String mimeType;

    public JrePathBasedBlob(Object platformBlob) {
        this(platformBlob, null);
    }

    public JrePathBasedBlob(Object platformBlob, String mimeType) {
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
