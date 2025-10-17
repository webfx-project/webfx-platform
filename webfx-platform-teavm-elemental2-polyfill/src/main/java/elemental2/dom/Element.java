package elemental2.dom;

import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
public abstract class Element extends Node {

    public native boolean hasAttribute(String name);

    public native String getAttribute(String name);

    public native void setAttribute(String name, String value);

    public native void setAttribute(String name, double value);

    public native void removeAttribute(String name);

    public native void focus();

    public native DOMRect getBoundingClientRect();

    @JSFunctor
    interface OncontextmenuFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    interface OnloadFn extends JSObject {
        void onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnwheelFn extends JSObject {
        Object onInvoke(Event p0);
    }
}
