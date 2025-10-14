package elemental2.dom;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
public interface RequestInit extends JSObject {

    void setMethod(String method);

    void setMode(String mode);

    void setHeaders(Headers headers);

    void setBody(String body);

    void setBody(Blob body);

    void setBody(FormData formData);

    @JSBody(script = "return new RequestInit();")
    static RequestInit create() { return null; }

}
