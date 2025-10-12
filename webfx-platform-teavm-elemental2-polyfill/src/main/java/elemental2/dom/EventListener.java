package elemental2.dom;

import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
@JSFunctor
public interface EventListener<E extends Event> extends JSObject {
    void handleEvent(E evt);
}