package jsinterop.base;

import org.teavm.jso.JSBody;

/**
 * @author Bruno Salmon
 */
public final class Js {

    @JSBody(params = {"obj"}, script = "return obj;")
    public static native JsPropertyMap<Object> asPropertyMap(Object obj);

    public static <T> T cast(Object obj) {
        return (T) obj;
    }

    @JSBody(params = {"obj"}, script = "return typeof obj;")
    public static native String typeof(Object obj);

}