package dev.webfx.platform.blob;

import dev.webfx.platform.blob.spi.BlobProvider;

/**
 * @author Bruno Salmon
 */
public interface Blob {

    Object getPlatformBlob();

    long length();

    String getMimeType();

    String getObjectURL();

    static Blob create(Object platformBlob) {
        return BlobProvider.get().createBlob(platformBlob);
    }

}
