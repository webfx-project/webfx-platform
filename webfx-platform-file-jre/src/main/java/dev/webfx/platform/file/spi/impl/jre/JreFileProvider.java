package dev.webfx.platform.file.spi.impl.jre;

import dev.webfx.platform.file.File;
import dev.webfx.platform.file.FileReader;
import dev.webfx.platform.file.spi.FileProvider;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bruno Salmon
 */
public final class JreFileProvider implements FileProvider {

    @Override
    public File createFile(Object platformFile) {
        return new JreFile((java.io.File) platformFile);
    }

    @Override
    public List<File> createFileList(Object platformFileList) {
        List<?> javaFileList = (List<?>) platformFileList;
        return javaFileList.stream().map(this::createFile).collect(Collectors.toList());
    }

    @Override
    public FileReader createFileReader() {
        return new JreFileReader();
    }
}
