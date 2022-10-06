package dev.webfx.platform.file.spi.impl.gwt;

import dev.webfx.platform.file.File;
import dev.webfx.platform.file.FileReader;
import dev.webfx.platform.file.spi.FileProvider;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bruno Salmon
 */
public class GwtFileProvider implements FileProvider {

    @Override
    public File createFile(Object platformFile) {
        return new GwtFile((elemental2.dom.File) platformFile);
    }

    @Override
    public List<File> createFileList(Object platformFileList) {
        elemental2.dom.FileList jsFileList = (elemental2.dom.FileList) platformFileList;
        return jsFileList.asList().stream().map(this::createFile).collect(Collectors.toList());
    }

    @Override
    public FileReader createFileReader() {
        return new GwtFileReader();
    }
}
