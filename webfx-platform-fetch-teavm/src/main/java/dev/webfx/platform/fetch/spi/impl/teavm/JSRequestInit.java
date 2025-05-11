package dev.webfx.platform.fetch.spi.impl.teavm;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

/**
 * @author Bruno Salmon
 */
interface JSRequestInit extends JSObject {

    @JSProperty
    void setMode(String method);

    @JSProperty
    void setMethod(String method);

    @JSProperty
    void setHeaders(JSHeaders headers);

    @JSProperty
    void setBody(String body);

    @JSProperty
    void setBody(JSObject blob);

}
