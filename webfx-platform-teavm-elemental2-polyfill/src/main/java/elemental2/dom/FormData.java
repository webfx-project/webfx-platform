package elemental2.dom;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
public interface FormData extends JSObject {

    interface SetValueUnionType extends JSObject {

        @JSBody(params = {"object"}, script = "return object")
        static SetValueUnionType of(Object object) { return null; }
    }

    void set(String name, String value);

    void set(String name, SetValueUnionType value, String filename);

    @JSBody(script = "return new FormData();")
    static FormData create() { return null; }

}
