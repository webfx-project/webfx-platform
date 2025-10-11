package dev.webfx.platform.blob.spi.impl.jre;

import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.blob.spi.BlobProvider;

/**
 * @author Bruno Salmon
 */
public final class JreBlobProvider implements BlobProvider {

    @Override
    public Blob createBlob(Object platformBlob) {
        return null;
    }

    @Override
    public Blob createTextBlob(String text) {
        return null;
    }

    @Override
    public void downloadUrl(String url, String fileName) {

    }
}
