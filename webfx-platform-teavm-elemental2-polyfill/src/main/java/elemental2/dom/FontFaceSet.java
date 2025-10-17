package elemental2.dom;

import elemental2.promise.Promise;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

/**
 * @author Bruno Salmon
 */
public interface FontFaceSet extends EventTarget {

    @JSProperty
    Promise<FontFaceSet> getReady();

    void add(FontFace value);

    void delete(FontFace value);

    @JSProperty
    void setOnloadingdone(FontFaceSet.OnloadingdoneFn onloadingdone);

    @JSFunctor
    interface OnloadingdoneFn extends JSObject {
        Object onInvoke(Event p0);
    }

}
