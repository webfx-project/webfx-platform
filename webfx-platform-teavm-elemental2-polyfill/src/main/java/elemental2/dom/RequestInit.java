package elemental2.dom;

import dev.webfx.platform.util.teavm.TeaVmUtil;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
public abstract class RequestInit implements JSObject {

    public void setMethod(String method) {
        TeaVmUtil.setString(this, "method", method);
    }

    public void setMode(String mode) {
        TeaVmUtil.setString(this, "mode", mode);
    }

    public void setHeaders(Headers headers) {
        TeaVmUtil.setJSObject(this, "headers", headers);
    }

    public void setBody(String body) {
        TeaVmUtil.setString(this, "body", body);
    }

    public void setBody(Blob body) {
        TeaVmUtil.setJSObject(this, "body", body);
    }

    public void setBody(FormData formData) {
        TeaVmUtil.setJSObject(this, "body", formData);
    }

    @JSBody(script = "return {};")
    static RequestInit create() { return null; }

}
