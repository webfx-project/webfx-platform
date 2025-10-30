package jsinterop.base;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;
import org.teavm.jso.core.JSBoolean;
import org.teavm.jso.core.JSNumber;
import org.teavm.jso.core.JSString;

/**
 * @author Bruno Salmon
 */
public final class Js {

    @JSBody(params = {"obj"}, script = "return obj;")
    public static native JsPropertyMap<Object> asPropertyMap(Object obj);

    public static <T> T cast(Object o) {
        if (o instanceof JSObject)
            return (T) o;
        if (o instanceof String s)
            return (T) JSString.valueOf(s);
        if (o instanceof Number n)
            return (T) JSNumber.valueOf(n.doubleValue());
        if (o instanceof Boolean b)
            return (T) JSBoolean.valueOf(b);
        return (T) o;
    }

    public static <T> T uncheckedCast(Object obj) {
        return cast(obj); // (T) obj; was causing issue with the pen heat in the cube demo
    }

    @JSBody(params = {"obj"}, script = "return typeof obj;")
    public static native String typeof(Object obj);

}