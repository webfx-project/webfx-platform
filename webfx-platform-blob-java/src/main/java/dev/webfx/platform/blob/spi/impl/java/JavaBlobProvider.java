package dev.webfx.platform.blob.spi.impl.java;

import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.blob.spi.BlobProvider;

/**
 * @author Bruno Salmon
 */
public final class JavaBlobProvider implements BlobProvider {

    @Override
    public Blob createBlob(Object platformBlob) {
        return null;
    }

    @Override
    public Blob createTextBlob(String text) {
        return null;
    }

    @Override
    public void exportBlob(Blob blob, String fileName) {

    }
}
