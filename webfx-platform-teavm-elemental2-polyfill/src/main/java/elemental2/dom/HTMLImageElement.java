package elemental2.dom;

import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
public abstract class HTMLImageElement extends HTMLElement {

    @JSFunctor
    public interface OnerrorFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnloadFn extends JSObject {
        Object onInvoke(Event p0);
    }

}
