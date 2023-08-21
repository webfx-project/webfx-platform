package dev.webfx.platform.file.spi.impl.java;

import dev.webfx.platform.file.Blob;
import dev.webfx.platform.file.spi.BlobProvider;

/**
 * @author Bruno Salmon
 */
public final class JavaBlobProvider implements BlobProvider {

    @Override
    public Blob createTextBlob(String text) {
        return null;
    }

    @Override
    public void exportBlob(Blob blob, String fileName) {

    }
}
