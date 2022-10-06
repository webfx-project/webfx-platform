package dev.webfx.platform.file.spi.impl.gwt;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import dev.webfx.platform.file.File;
import dev.webfx.platform.file.FileReader;

/**
 * @author Bruno Salmon
 */
final class GwtFileReader implements FileReader {

    private final elemental2.dom.FileReader jsFileReader = new elemental2.dom.FileReader();

    @Override
    public Future<String> readAsText(File file) {
        Promise<String> promise = Promise.promise();
        GwtFile gwtFile = (GwtFile) file;
        jsFileReader.readAsText(gwtFile.getPlatformFile());
        jsFileReader.onloadend = pe -> {
            promise.complete(jsFileReader.result.toString());
            return null;
        };
        return promise.future();
    }
}
