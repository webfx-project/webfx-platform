package jsinterop.base;

import org.teavm.jso.JSBody;

/**
 * @author Bruno Salmon
 */
public final class Js {

    @JSBody(params = {"obj"}, script = "return obj;")
    public static native JsPropertyMap<Object> asPropertyMap(Object obj);

}