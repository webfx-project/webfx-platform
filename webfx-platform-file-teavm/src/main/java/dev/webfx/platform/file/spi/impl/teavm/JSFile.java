package dev.webfx.platform.file.spi.impl.teavm;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;
import org.teavm.jso.core.JSArrayReader;

/**
 * @author Bruno Salmon
 */
final class JSFile extends org.teavm.jso.file.File {

    public JSFile(JSArrayReader<JSObject> array, String fileName) {
        super(array, fileName);
    }

    public JSFile(JSArrayReader<JSObject> array, String fileName, JSObject options) {
        super(array, fileName, options);
    }

    @JSProperty
    public native String getWebkitRelativePath();
}
