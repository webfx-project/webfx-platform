package elemental2.dom;

import elemental2.promise.Promise;
import org.teavm.jso.JSClass;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class Window implements JSObject, WindowEventTarget {

    public History history;

    public Window opener;

    public Location location;

    public Window.OnpopstateFn onpopstate;

    public abstract Window open(String url);

    public abstract Promise<Response> fetch(String url);

    public abstract Promise<Response> fetch(String url, RequestInit requestInit);

    public abstract Promise<Response> fetch(Request input);

    public abstract void close();

    @JSFunctor
    public interface OnabortFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnbeforeunloadFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnblurFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnchangeFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnclickFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OncloseFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OncontextmenuFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OndblclickFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OndragdropFn extends JSObject {
        Object onInvoke(Event p0);
    }

    /*@JSFunctor
    public interface OnerrorFn extends JSObject {
        Object onInvoke(String p0, String p1, double p2, double p3, JsError p4);
    }*/

    @JSFunctor
    public interface OnfocusFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnhashchangeFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnkeydownFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnkeypressFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnkeyupFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnloadFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnmousedownFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnmousemoveFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnmouseoutFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnmouseoverFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnmouseupFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnmousewheelFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnpaintFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnpopstateFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnresetFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnresizeFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnscrollFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnselectFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnstorageFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnsubmitFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnunhandledrejectionFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnunloadFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnwheelFn extends JSObject {
        Object onInvoke(Event p0);
    }

}
