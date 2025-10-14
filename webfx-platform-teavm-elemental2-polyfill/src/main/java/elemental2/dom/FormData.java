package elemental2.dom;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSClass;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
@JSClass
public class FormData implements JSObject {

    interface SetValueUnionType extends JSObject {

        @JSBody(params = {"object"}, script = "return object")
        static SetValueUnionType of(Object object) { return null; }
    }

    public native void set(String name, String value);

    @JSBody(params = {"name", "value", "filename"}, script = "this.set(name, value, filename);")
    public native void set(String name, SetValueUnionType value, String filename);


}
