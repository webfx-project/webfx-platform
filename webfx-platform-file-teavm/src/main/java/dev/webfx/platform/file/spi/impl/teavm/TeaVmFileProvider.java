package dev.webfx.platform.file.spi.impl.teavm;

import dev.webfx.platform.file.File;
import dev.webfx.platform.file.FileReader;
import dev.webfx.platform.file.spi.FileProvider;
import dev.webfx.platform.util.Arrays;

import java.util.List;

/**
 * @author Bruno Salmon
 */
public final class TeaVmFileProvider implements FileProvider {

    @Override
    public File createFile(Object platformFile) {
        return new TeaVmFile((JSFile) platformFile);
    }

    @Override
    public List<File> createFileList(Object platformFileList) {
        JSFile[] jsFileList = (JSFile[]) platformFileList;
        File[] map = Arrays.map(jsFileList, this::createFile, File[]::new);
        return List.of(map);
    }

    @Override
    public FileReader createFileReader() {
        return new TeaVmFileReader();
    }
}