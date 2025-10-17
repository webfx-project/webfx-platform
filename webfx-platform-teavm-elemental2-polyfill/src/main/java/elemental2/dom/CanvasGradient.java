package elemental2.dom;

import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
public interface CanvasGradient extends JSObject {

    void addColorStop(double offset, String color);

}
