package dev.webfx.platform.file.spi.impl.teavm;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;
import org.teavm.jso.dom.events.EventTarget;

/**
 * @author Bruno Salmon
 */
public interface JSFileReader extends EventTarget {

    void readAsText(JSObject blob);

    void readAsArrayBuffer(JSObject blob);

    @JSProperty
    JSObject getResult();

}
