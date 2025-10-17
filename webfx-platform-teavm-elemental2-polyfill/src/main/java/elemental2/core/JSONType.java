package elemental2.core;

import org.teavm.jso.JSClass;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
@JSClass
public class JSONType implements JSObject {

    public native Object parse(String jsonStr);

    public native String stringify(Object jsonObj);

}
