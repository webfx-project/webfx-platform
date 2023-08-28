package dev.webfx.platform.file;

import dev.webfx.platform.file.spi.BlobProvider;

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
