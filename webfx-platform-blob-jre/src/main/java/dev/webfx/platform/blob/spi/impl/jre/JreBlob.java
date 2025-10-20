package dev.webfx.platform.blob.spi.impl.jre;

import dev.webfx.platform.blob.Blob;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * @author Bruno Salmon
 */
public abstract class JreBlob implements Blob {

    private final Object platformBlob;

    public JreBlob(Object platformBlob) {
        this.platformBlob = platformBlob;
    }

    @Override
    public Object getPlatformBlob() {
        return platformBlob;
    }

    protected abstract URI toURI();

    protected URL toURL() throws MalformedURLException {
        return toURI().toURL();
    }

    @Override
    public String getObjectURL() {
        try {
            return toURL().toExternalForm();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
