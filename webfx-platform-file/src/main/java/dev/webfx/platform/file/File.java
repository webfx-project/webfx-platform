package dev.webfx.platform.file;

import dev.webfx.platform.file.spi.FileProvider;

import java.util.List;

/**
 * @author Bruno Salmon
 */
public interface File {

    Object getPlatformFile();

    String getName();

    long length();

    long lastModified();

    String getMimeType();

    String getObjectURL();

    String getParentPath(); // experimental

    static File create(Object platformFile) {
        return FileProvider.get().createFile(platformFile);
    }

    static List<File> createFileList(Object platformFileList) {
        return FileProvider.get().createFileList(platformFileList);
    }

}
