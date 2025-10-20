package elemental2.dom;

import dev.webfx.platform.util.teavm.TeaVmUtil;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

/**
 * @author Bruno Salmon
 */
public interface AddEventListenerOptions extends EventListenerOptions {

    default void setPassive(boolean passive) {
        TeaVmUtil.setBoolean(this, "passive", passive);
    }

    static AddEventListenerOptions create() {
        return Js.uncheckedCast(JsPropertyMap.of());
    }
}
