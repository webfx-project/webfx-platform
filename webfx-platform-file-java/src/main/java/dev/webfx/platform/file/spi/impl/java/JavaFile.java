package dev.webfx.platform.file.spi.impl.java;

import dev.webfx.platform.file.File;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;

/**
 * @author Bruno Salmon
 */
public final class JavaFile implements File {

    private final java.io.File javaPlatformFile;

    public JavaFile(java.io.File javaPlatformFile) {
        this.javaPlatformFile = javaPlatformFile;
    }

    @Override
    public java.io.File getPlatformFile() {
        return javaPlatformFile;
    }

    @Override
    public String getName() {
        return javaPlatformFile.getName();
    }

    @Override
    public long length() {
        return javaPlatformFile.length();
    }

    @Override
    public long lastModified() {
        return javaPlatformFile.lastModified();
    }

    @Override
    public String getParentPath() {
        return javaPlatformFile.getParentFile().getPath();
    }

    @Override
    public String getURLPath() {
        try {
            return javaPlatformFile.toURI().toURL().toExternalForm();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getMimeType() {
        try {
            return Files.probeContentType(javaPlatformFile.toPath());
        } catch (IOException e) {
            return null;
        }
    }
}
