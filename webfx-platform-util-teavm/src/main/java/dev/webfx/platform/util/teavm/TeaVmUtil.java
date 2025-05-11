package dev.webfx.platform.util.teavm;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;
import org.teavm.jso.core.JSPromise;

import java.util.Iterator;
import java.util.function.Function;

/**
 * @author Bruno Salmon
 */
public class TeaVmUtil {

    @JSBody(params = { "o" }, script = "return typeof o;")
    public static native String typeOf(JSObject o);

    public static boolean isFunction(JSObject o) {
        return "function".equals(typeOf(o));
    }

    @JSBody(script = "return window.navigator.userAgent;")
    public static native String getUserAgent();

    @JSBody(script = "return window.navigator.platform;")
    public static native String getPlatform();

    @JSBody(script = "return window.navigator.cpuClass;")
    public static native String getCpuClass();

    @JSBody(script = "return window.navigator.hardwareConcurrency;")
    public static native Integer getHardwareConcurrency();

    @JSBody(params = { "obj", "prop" }, script = "return obj[prop];")
    public static native JSObject getJSObject(JSObject obj, String prop);

    public static JSObject getJSObject(JSObject obj, String... props) {
        JSObject result = getLastJSObject(obj, props);
        return result == null ? null : getJSObject(result, props[props.length - 1]);
    }

    private static JSObject getLastJSObject(JSObject obj, String... props) {
        JSObject result = obj;
        for (int i = 0; i < props.length - 2; i++) {
            result = getJSObject(result, props[i]);
            if (result == null)
                break;
        }
        return result;
    }

    @JSBody(params = { "obj", "prop" }, script = "return obj[prop];")
    public static native String getJSString(JSObject obj, String prop);

    public static String getJSString(JSObject obj, String... props) {
        JSObject result = getLastJSObject(obj, props);
        return result == null ? null : getJSString(result, props[props.length - 1]);
    }

    @JSBody(params = { "obj", "prop" }, script = "return obj[prop];")
    public static native Boolean getJSBoolean(JSObject obj, String prop);

    public static Boolean getJSBoolean(JSObject obj, String... props) {
        JSObject result = getLastJSObject(obj, props);
        return result == null ? null : getJSBoolean(result, props[props.length - 1]);
    }

    @JSBody(params = { "obj", "prop" }, script = "return obj[prop];")
    public static native Integer getJSInteger(JSObject obj, String prop);

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
