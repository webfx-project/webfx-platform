package elemental2.dom;

import elemental2.promise.Promise;
import org.teavm.jso.JSClass;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class HTMLMediaElement extends HTMLElement {

    @JSFunctor
    public interface OnendedFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnerrorFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnloadeddataFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnloadedmetadataFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnpauseFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnplayFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnplayingFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OnprogressFn extends JSObject {
        Object onInvoke(Event p0);
    }

    @JSFunctor
    public interface OntimeupdateFn extends JSObject {
        Object onInvoke(Event p0);
    }

    public OntimeupdateFn ontimeupdate;
    public double duration;

    public native void pause();

    public native Promise<Void> play();

}
