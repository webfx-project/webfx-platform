package dev.webfx.platform.blob.spi;

import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.service.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public interface BlobProvider {

    static BlobProvider get() {
        return SingleServiceProvider.getProvider(BlobProvider.class, () -> ServiceLoader.load(BlobProvider.class));
    }

    Blob createBlob(Object platformBlob);

    Blob createTextBlob(String text);

    default void exportBlob(Blob blob) {
        exportBlob(blob, null);
    }

    default void exportBlob(Blob blob, String fileName) {
        downloadUrl(blob.getObjectURL(), fileName);
    }

    default void downloadUrl(String url) {
        downloadUrl(url, null);
    }

    void downloadUrl(String url, String fileName);

}
