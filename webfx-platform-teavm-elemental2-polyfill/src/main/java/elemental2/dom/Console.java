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
        logImpl(toJsArray(args));
    }

    public void info(Object... args) {
        infoImpl(toJsArray(args));
    }

    public void warn(Object... args) {
        warnImpl(toJsArray(args));
    }

    public void debug(Object... args) {
        debugImpl(toJsArray(args));
    }

    public void error(Object... args) {
        errorImpl(toJsArray(args));
    }

    public void trace(Object... args) {
        traceImpl(toJsArray(args));
    }

    private JSArray<JSObject> toJsArray(Object[] args) {
        var jsArgs = new JSArray<JSObject>(args.length);
        for (int i = 0; i < args.length; i++) {
            var arg = args[i];
            if (arg instanceof JSObject jsArg) {
                jsArgs.set(i, jsArg);
            } else if (arg instanceof String str) {
                jsArgs.set(i, JSString.valueOf(str));
            } else if (arg instanceof Throwable throwable) {
                jsArgs.set(i, throwableToJsError(throwable));
            } else {
                jsArgs.set(i, asJs(arg));
            }
        }
        return jsArgs;
    }

    @JSBody(params = "t", script = "return t && (t.$jsError || t);")
    private static native JSObject throwableToJsError(Object t);

    @JSBody(params = "args", script = "console.log.apply(console, args);")
    private static native void logImpl(JSArrayReader<JSObject> args);

    @JSBody(params = "args", script = "console.info.apply(console, args);")
    private static native void infoImpl(JSArrayReader<JSObject> args);

    @JSBody(params = "args", script = "console.warn.apply(console, args);")
    private static native void warnImpl(JSArrayReader<JSObject> args);

    @JSBody(params = "args", script = "console.debug.apply(console, args);")
    private static native void debugImpl(JSArrayReader<JSObject> args);

    @JSBody(params = "args", script = "console.error.apply(console, args);")
    private static native void errorImpl(JSArrayReader<JSObject> args);

    @JSBody(params = "args", script = "console.trace.apply(console, args);")
    private static native void traceImpl(JSArrayReader<JSObject> args);

    @JSBody(params = "o", script = "return o;")
    private static native JSObject asJs(Object o);
}