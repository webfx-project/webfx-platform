package elemental2.dom;

import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

/**
 * @author Bruno Salmon
 */
public interface EventInit extends JSObject {

    static EventInit create() {
        return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JSProperty
    boolean isBubbles();

    @JSProperty
    boolean isCancelable();

    @JSProperty
    boolean isComposed();

    @JSProperty
    void setBubbles(boolean bubbles);

    @JSProperty
    void setCancelable(boolean cancelable);

    @JSProperty
    void setComposed(boolean composed);

}
