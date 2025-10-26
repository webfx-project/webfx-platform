package elemental2.core;

import elemental2.dom.JsArrayLike;
import elemental2.dom.JsIterable;
import org.teavm.jso.JSClass;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class TypedArray extends ArrayBufferView implements JsIterable<Double>, JsArrayLike<Double> {
}
