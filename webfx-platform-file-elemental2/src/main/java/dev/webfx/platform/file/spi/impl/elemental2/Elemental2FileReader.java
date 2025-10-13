package dev.webfx.platform.file.spi.impl.elemental2;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import dev.webfx.platform.file.File;
import dev.webfx.platform.file.FileReader;
import elemental2.core.ArrayBuffer;
import elemental2.core.DataView;

/**
 * @author Bruno Salmon
 */
final class Elemental2FileReader implements FileReader {

    private final elemental2.dom.FileReader jsFileReader = new elemental2.dom.FileReader();

    @Override
    public Future<String> readAsText(File file) {
        Promise<String> promise = Promise.promise();
        Elemental2File elemental2File = (Elemental2File) file;
        jsFileReader.readAsText(elemental2File.getPlatformBlob());
        jsFileReader.onloadend = pe -> {
            try {
                promise.complete(jsFileReader.result.toString());
            } catch (Throwable throwable) {
                promise.fail(throwable);
            }
            return null;
        };
        return promise.future();
    }

    @Override
    public Future<byte[]> readAsBytes(File file) {
        Promise<byte[]> promise = Promise.promise();
        Elemental2File elemental2File = (Elemental2File) file;
        jsFileReader.readAsArrayBuffer(elemental2File.getPlatformBlob());
        jsFileReader.onloadend = pe -> {
            try {
                ArrayBuffer arrayBuffer = (ArrayBuffer) (jsFileReader.result);
                DataView dataView = new DataView(arrayBuffer);
                int n = arrayBuffer.byteLength;
                byte[] result = new byte[n];
                for (int i = 0; i < n; i++)
                    result[i] = (byte) dataView.getInt8(i);
                promise.complete(result);
            } catch (Throwable throwable) {
                promise.fail(throwable);
            }
            return null;
        };
        return promise.future();
    }
}
