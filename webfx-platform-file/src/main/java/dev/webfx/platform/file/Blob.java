package dev.webfx.platform.file;

/**
 * @author Bruno Salmon
 */
public interface Blob {

    Object getPlatformBlob();

    long length();

    String getMimeType();

    String getObjectURL();

}
