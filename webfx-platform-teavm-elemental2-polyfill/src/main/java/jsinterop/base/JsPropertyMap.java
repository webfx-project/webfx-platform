package jsinterop.base;

import dev.webfx.platform.util.teavm.TeaVmUtil;
import org.teavm.jso.JSObject;
import org.teavm.jso.core.JSObjects;

/**
 * @author Bruno Salmon
 */
public interface JsPropertyMap<T> extends JSObject {

    default T get(String propertyName) {
        return (T) TeaVmUtil.jsToJava(TeaVmUtil.getJSObject(this, propertyName));
    }


    static <T> JsPropertyMap<T> of() {
        return JSObjects.create();
    }

    default void set(String propertyName, T value) {
        TeaVmUtil.set(this, propertyName, value);
    }

    static <T> JsPropertyMap<T> of(String k, /*@DoNotAutobox*/ T v) {
        JsPropertyMap<T> map = of();
        map.set(k, v);
        return map;
    }

    static <T> JsPropertyMap<T> of(String k1, /*@DoNotAutobox*/ T v1, String k2, /*@DoNotAutobox*/ T v2) {
        JsPropertyMap<T> map = of();
        map.set(k1, v1);
        map.set(k2, v2);
        return map;
    }

}
