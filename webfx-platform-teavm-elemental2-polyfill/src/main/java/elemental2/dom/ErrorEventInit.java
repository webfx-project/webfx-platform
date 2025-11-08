package elemental2.dom;

import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.teavm.jso.JSProperty;

/**
 * @author Bruno Salmon
 */
public interface ErrorEventInit extends EventInit {

    static ErrorEventInit create() {
        return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JSProperty
    int getColno();

    @JSProperty
    Object getError();

    @JSProperty
    String getFilename();

    @JSProperty
    int getLineno();

    @JSProperty
    String getMessage();

    @JSProperty
    void setColno(int colno);

    @JSProperty
    void setError(Object error);

    @JSProperty
    void setFilename(String filename);

    @JSProperty
    void setLineno(int lineno);

    @JSProperty
    void setMessage(String message);
}
