package jsinterop.base;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
public interface JsPropertyMap<T> extends JSObject {

    @JSBody(params = {"propertyName"}, script =
        "var value = this[propertyName];" +
        "if (value === undefined || value === null) return null;" +
        "return typeof value === 'string' ? $rt_str(value) : value;")
    T get(String propertyName);

    @JSBody(script = "return {};")
    static <T> JsPropertyMap<T> of() {
        return null;
    }

    @JSBody(params = {"propertyName", "value"}, script = "this[propertyName] = value;")
    void set(String propertyName, T value);

}
