package jsinterop.base;

import dev.webfx.platform.util.teavm.TeaVmUtil;
import org.teavm.jso.JSBody;
import org.teavm.jso.core.JSObjects;

/**
 * @author Bruno Salmon
 */
public final class Js {

    @JSBody(params = {"obj"}, script = "return obj;")
    public static native JsPropertyMap<Object> asPropertyMap(Object obj);

    public static <T> T cast(Object obj) {
        return (T) TeaVmUtil.javaToJs(obj);
    }

    public static <T> T uncheckedCast(Object obj) {
        return cast(obj);
    }

    public static String typeof(Object obj) {
        return JSObjects.typeOf(obj);
    }

}