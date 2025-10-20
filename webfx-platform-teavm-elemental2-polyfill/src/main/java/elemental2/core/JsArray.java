package elemental2.core;

import elemental2.dom.JsArrayLike;
import elemental2.dom.JsIterable;
import org.teavm.jso.JSClass;

/**
 * @author Bruno Salmon
 */
@JSClass(name = "Array")
public class JsArray<T> implements JsIterable<T>, ReadonlyArray<T>, JsArrayLike<T> {

    public static native <T> JsArray<T> of(T... var_args);

}
