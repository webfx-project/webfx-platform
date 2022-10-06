package dev.webfx.platform.file.spi;

import dev.webfx.platform.file.File;
import dev.webfx.platform.file.FileReader;
import dev.webfx.platform.util.serviceloader.SingleServiceProvider;

import java.util.List;
import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public interface FileProvider {

    static FileProvider get() {
        return SingleServiceProvider.getProvider(FileProvider.class, () -> ServiceLoader.load(FileProvider.class));
    }

    File createFile(Object platformFile);

    List<File> createFileList(Object platformFileList);

    FileReader createFileReader();

}
