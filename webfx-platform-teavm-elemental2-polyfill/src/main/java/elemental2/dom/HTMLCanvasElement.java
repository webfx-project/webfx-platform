package elemental2.dom;

import elemental2.core.JsObject;
import jsinterop.base.Js;
import org.teavm.jso.JSClass;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class HTMLCanvasElement extends HTMLElement {

    public native JsObject getContext(String contextId, JsObject args);

    //@JsOverlay
    public final JsObject getContext(String contextId, Object args) {
        return getContext(contextId, Js.<JsObject>uncheckedCast(args));
    }

    public native JsObject getContext(String contextId);

}
