package elemental2.webgl;

import org.teavm.jso.JSClass;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
@JSClass
public class WebGLActiveInfo implements JSObject {
    public String name;
    public int size;
    public int type;
}
