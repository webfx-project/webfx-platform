package dev.webfx.platform.file.spi;

import dev.webfx.platform.file.Blob;
import dev.webfx.platform.util.serviceloader.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public interface BlobProvider {

    static BlobProvider get() {
        return SingleServiceProvider.getProvider(BlobProvider.class, () -> ServiceLoader.load(BlobProvider.class));
    }

    Blob createTextBlob(String text);

    void exportBlob(Blob blob, String fileName);

}
