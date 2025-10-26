package elemental2.dom;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSClass;
import org.teavm.jso.JSObject;
import org.teavm.jso.core.JSArray;
import org.teavm.jso.core.JSArrayReader;
import org.teavm.jso.core.JSString;

/**
 * TeaVM polyfill for Elemental2's Console class
 */
@JSClass
public final class Console implements JSObject {

    public void log(Object... args) {
        var jsArgs = new JSArray<JSObject>(args.length);
        for (int i = 0; i < args.length; i++) {
            var arg = args[i];
            if (arg instanceof JSObject jsArg) {
                jsArgs.set(i, jsArg);
            } else if (args[i] instanceof String str) {
                jsArgs.set(i, JSString.valueOf(str));
            } else {
                jsArgs.set(i, asJs(arg));
            }
        }
        logImpl(jsArgs);
    }

    @JSBody(params = "args", script = "console.log.apply(console, args);")
    private static native void logImpl(JSArrayReader<JSObject> args);

    @JSBody(params = "o", script = "return o;")
    private static native JSObject asJs(Object o);
}