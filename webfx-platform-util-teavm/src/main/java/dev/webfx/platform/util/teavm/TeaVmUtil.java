package dev.webfx.platform.util.teavm;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;
import org.teavm.jso.browser.Window;
import org.teavm.jso.core.JSObjects;
import org.teavm.jso.core.JSPromise;

import java.util.Iterator;
import java.util.function.Function;

/**
 * @author Bruno Salmon
 */
public class TeaVmUtil {

    public static boolean isFunction(JSObject o) {
        return "function".equals(JSObjects.typeOf(o));
    }

    @JSBody(script = "return window.navigator.userAgent;")
    public static native String getUserAgent();

    @JSBody(script = "return window.navigator.platform;")
    public static native String getPlatform();

    @JSBody(script = "return window.navigator.cpuClass;")
    public static native String getCpuClass();

    public static Integer getHardwareConcurrency() {
        return getJSInteger(Window.current(), "navigator", "hardwareConcurrency");
    };

    @JSBody(script = "return document.visibilityState;")
    public static native String getVisibilityState();

    @JSBody(params = { "obj", "prop" }, script = "return obj[prop];")
    public static native JSObject getJSObject(JSObject obj, String prop);

    private static JSObject getLastJSObject(JSObject obj, String... props) {
        JSObject result = obj;
        for (int i = 0; i < props.length - 1; i++) {
            result = getJSObject(result, props[i]);
            if (result == null || JSObjects.isUndefined(result))
                break;
        }
        return result;
    }

    public static Boolean getJSBoolean(JSObject obj, String prop) {
        JSObject value = getJSObject(obj, prop);
        if (value == null || JSObjects.isUndefined(value))
            return null;
        // Cast JSObject to boolean using a simple JS body that returns the value as-is
        return jsCastToBoolean(value);
    }
    
    @JSBody(params = { "value" }, script = "return value;")
    private static native boolean jsCastToBoolean(JSObject value);

    public static Boolean getJSBoolean(JSObject obj, String... props) {
        JSObject result = getLastJSObject(obj, props);
        return result == null ? null : getJSBoolean(result, props[props.length - 1]);
    }

    public static Integer getJSInteger(JSObject obj, String prop) {
        JSObject value = getJSObject(obj, prop);
        if (value == null || JSObjects.isUndefined(value))
            return null;
        return jsCastToInt(value);
    }
    
    @JSBody(params = { "value" }, script = "return value;")
    private static native int jsCastToInt(JSObject value);

    public static Integer getJSInteger(JSObject obj, String... props) {
        JSObject result = getLastJSObject(obj, props);
        return result == null ? null : getJSInteger(result, props[props.length - 1]);
    }

    public static <J extends JSObject, T> Future<T> jsPromiseToWebFXFuture(JSPromise<J> jsPromise, Function<J, T> jsResultConverter) {
        Promise<T> promise = Promise.promise();
        // Not sure about if then() and catch() are exclusive so using tryComplete() and tryFail() to avoid additional exceptions
        jsPromise
            .then(obj -> {
                promise.tryComplete(jsResultConverter.apply(obj));
                return null;
            })
            .catchError(error -> {
                if (error instanceof Throwable)
                    promise.tryFail((Throwable) error);
                else
                    promise.tryFail(error.toString());
                return null;
            });
        return promise.future();
    }

    public static <T> Iterator<T> jsIteratorToJavaIterator(JSIterator<T> jsIterator) {
        return new Iterator<>() {
            private JSIIterableResult<T> next = jsIterator.next();

            @Override
            public boolean hasNext() {
                return !next.isDone();
            }

            @Override
            public T next() {
                T value = next.getValue();
                next = jsIterator.next();
                return value;
            }
        };
    }

}
