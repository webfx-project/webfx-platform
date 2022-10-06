package dev.webfx.platform.file.spi.impl.java;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.file.File;
import dev.webfx.platform.file.FileReader;

import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Bruno Salmon
 */
final class JavaFileReader implements FileReader {

    @Override
    public Future<String> readAsText(File file) {
        try {
            JavaFile peer = (JavaFile) file;
            return Future.succeededFuture(new String(Files.readAllBytes((peer.getPlatformFile().toPath()))));
        } catch (IOException e) {
            Future.failedFuture(e);
        }
        return null;
    }
}
