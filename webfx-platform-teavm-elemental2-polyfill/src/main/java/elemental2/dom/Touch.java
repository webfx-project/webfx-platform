package elemental2.dom;

import org.teavm.jso.JSClass;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
@JSClass
public class Touch implements JSObject {
    public double clientX;
    public double clientY;
    public double force;
    public int identifier;
    public double pageX;
    public double pageY;
    public double radiusX;
    public double radiusY;
    public double rotationAngle;
    public double screenX;
    public double screenY;
    public EventTarget target;

    //public Touch(TouchInitDict touchInitDict) {}
}
