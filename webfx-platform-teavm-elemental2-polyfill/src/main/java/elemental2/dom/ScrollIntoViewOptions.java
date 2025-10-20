package elemental2.dom;

import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

/**
 * @author Bruno Salmon
 */
public interface ScrollIntoViewOptions extends JSObject {

    static ScrollIntoViewOptions create() {
        return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JSProperty
    String getBehavior();

    @JSProperty
    String getBlock();

    @JSProperty
    String getInline();

    @JSProperty
    void setBehavior(String behavior);

    @JSProperty
    void setBlock(String block);

    @JSProperty
    void setInline(String inline);
}
