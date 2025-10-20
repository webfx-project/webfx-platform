package elemental2.core;

import org.teavm.jso.JSClass;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
@JSClass(name = "Object")
public class JsObject implements JSObject {

    public static native JsObject create(JsObject proto);

}
