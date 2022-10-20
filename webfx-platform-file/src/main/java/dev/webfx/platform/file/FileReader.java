package dev.webfx.platform.file;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.file.spi.FileProvider;

/**
 * @author Bruno Salmon
 */
public interface FileReader {

    Future<String> readAsText(File file);

    Future<byte[]> readAsBytes(File file);

    static FileReader create() {
        return FileProvider.get().createFileReader();
    }

}
