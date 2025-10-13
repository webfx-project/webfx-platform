package elemental2.dom;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

/**
 * @author Bruno Salmon
 */
public interface History extends JSObject {

    @JSProperty
    int getLength();

}
