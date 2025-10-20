package elemental2.dom;

import jsinterop.base.JsPropertyMap;
import org.teavm.jso.JSClass;

/**
 * @author Bruno Salmon
 */
@JSClass
public class HTMLCollection<T> implements JsIterable<T>, JsArrayLike<T>, JsPropertyMap<T> {
    public int length;

    public native T item(int index);

    public native T namedItem(String name);
}