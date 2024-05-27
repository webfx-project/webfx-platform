package dev.webfx.platform.file.spi.impl.java;

import dev.webfx.platform.file.File;

import java.net.URI;
import java.nio.file.Path;

/**
 * @author Bruno Salmon
 */
public final class JavaFile extends JavaPathBasedBlob implements File {

    public JavaFile(java.io.File javaPlatformFile) {
        super(javaPlatformFile);
    }

    public JavaFile(Object platformBlob, String mimeType) {
        super(platformBlob, mimeType);
    }

    @Override
    public java.io.File getPlatformBlob() {
        return (java.io.File) super.getPlatformBlob();
    }

    @Override
    public String getName() {
        return getPlatformBlob().getName();
    }

    @Override
    public long length() {
        return getPlatformBlob().length();
    }

    @Override
    public long lastModified() {
        return getPlatformBlob().lastModified();
    }

    @Override
    protected Path toPath() {
        return getPlatformBlob().toPath();
    }

    @Override
    protected URI toURI() {
        return getPlatformBlob().toURI();
    }

    @Override
    public String getParentPath() {
        return getPlatformBlob().getParentFile().getPath();
    }

}
