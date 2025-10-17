package elemental2.dom;

import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
public interface EventTarget extends JSObject {

    void addEventListener(String type, EventListener listener, boolean useCapture);

    void addEventListener(String type, EventListener listener);

    void addEventListener(String type, EventListener listener, AddEventListenerOptions options);

    void removeEventListener(String type, EventListener listener, boolean useCapture);

    void removeEventListener(String type, EventListener listener);

    boolean dispatchEvent(Event evt);


    /*default Registration onEvent(String type, boolean useCapture, EventListener<?> listener) {
        addEventListener(type, listener, useCapture);
        return new Registration(this, type, listener, useCapture);
    }

    default Registration onEvent(String type, EventListener<?> listener) {
        addEventListener(type, listener);
        return new Registration(this, type, listener, null);
    }*/
}