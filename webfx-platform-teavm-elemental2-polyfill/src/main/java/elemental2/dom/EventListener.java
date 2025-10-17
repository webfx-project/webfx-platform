package elemental2.dom;

import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
@JSFunctor
public interface EventListener extends JSObject {
    void handleEvent(Event evt);
}