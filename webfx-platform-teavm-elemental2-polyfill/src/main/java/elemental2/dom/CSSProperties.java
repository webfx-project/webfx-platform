package elemental2.dom;

import jsinterop.base.Js;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
public interface CSSProperties extends JSObject {

    interface LineHeightUnionType {

        static CSSProperties.LineHeightUnionType of(Object o) {
            return Js.cast(o);
        }

    }

}
