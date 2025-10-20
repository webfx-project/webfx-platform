package elemental2.dom;

import elemental2.promise.Promise;
import jsinterop.base.Js;
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

    public native Promise<Void> requestFullscreen();

    public final void scrollIntoView(ScrollIntoViewOptions top) {
        scrollIntoView(Js.<Element.ScrollIntoViewTopUnionType>uncheckedCast(top));
    }

    public native void scrollIntoView(Element.ScrollIntoViewTopUnionType top);

    public interface ScrollIntoViewTopUnionType extends JSObject {
        static Element.ScrollIntoViewTopUnionType of(Object o) {
            return Js.cast(o);
        }
    }

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

    @JSFunctor
    public interface OninputFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OntouchstartFn extends JSObject {
        Object onInvoke(TouchEvent p0);
    }

    @JSFunctor
    public interface OnmousedownFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnkeypressFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnscrollFn extends JSObject {
        Object onInvoke(Event p0);
    }

}
