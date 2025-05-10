package dev.webfx.platform.file.spi.impl.teavm;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import dev.webfx.platform.file.File;
import dev.webfx.platform.file.FileReader;
import org.teavm.jso.JSBody;
import org.teavm.jso.typedarrays.ArrayBuffer;
import org.teavm.jso.typedarrays.Int8Array;

/**
 * @author Bruno Salmon
 */
final class TeaVmFileReader implements FileReader {

    private final JSFileReader jsFileReader = createFileReader();

    @Override
    public Future<String> readAsText(File file) {
        Promise<String> promise = Promise.promise();
        TeaVmFile teaVmFile = (TeaVmFile) file;
        jsFileReader.readAsText(teaVmFile.getPlatformBlob());
        jsFileReader.addEventListener("loadend", e -> {
            try {
                promise.complete(jsFileReader.getResult().toString());
            } catch (Throwable throwable) {
                promise.fail(throwable);
            }
        });
        return promise.future();
    }

    @Override
    public Future<byte[]> readAsBytes(File file) {
        Promise<byte[]> promise = Promise.promise();
        TeaVmFile teaVmFile = (TeaVmFile) file;
        jsFileReader.readAsArrayBuffer(teaVmFile.getPlatformBlob());
        jsFileReader.addEventListener("loadend", e -> {
            try {
                ArrayBuffer arrayBuffer = (ArrayBuffer) jsFileReader.getResult();
                Int8Array int8Array = new Int8Array(arrayBuffer);
                int n = arrayBuffer.getByteLength();
                byte[] result = new byte[n];
                for (int i = 0; i < n; i++)
                    result[i] = int8Array.get(i);
                promise.complete(result);
            } catch (Throwable throwable) {
                promise.fail(throwable);
            }
        });
        return promise.future();
    }

    @JSBody(script = "return new FileReader();")
    private static native JSFileReader createFileReader();

}