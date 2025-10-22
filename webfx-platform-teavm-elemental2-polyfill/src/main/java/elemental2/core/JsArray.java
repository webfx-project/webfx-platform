package elemental2.core;

import dev.webfx.platform.util.teavm.TeaVmUtil;
import elemental2.dom.JsArrayLike;
import elemental2.dom.JsIterable;
import org.teavm.jso.JSClass;
import org.teavm.jso.JSObject;
import org.teavm.jso.core.JSArray;

/**
 * @author Bruno Salmon
 */
@JSClass(name = "Array")
public class JsArray<T> implements JsIterable<T>, ReadonlyArray<T>, JsArrayLike<T> {

    public static <T> JsArray<T> of(T... var_args) {
        JSArray array = JSArray.create(var_args.length);
        for (int i = 0; i < var_args.length; ++i) {
            T arg = var_args[i];
            if (arg instanceof Number n)
                TeaVmUtil.setAt(array, i, n.doubleValue());
            else if (arg instanceof Boolean b)
                TeaVmUtil.setAt(array, i, b.booleanValue());
            else
                TeaVmUtil.setAt(array, i, arg);
        }
        return (JsArray<T>) (JSObject) array;
    }

}
