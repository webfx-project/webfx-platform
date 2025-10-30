package dev.webfx.platform.util.teavm;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;
import org.teavm.jso.core.JSBoolean;
import org.teavm.jso.core.JSNumber;
import org.teavm.jso.core.JSObjects;
import org.teavm.jso.core.JSString;

/**
 * @author Bruno Salmon
 */
public class TeaVmUtil {

    @JSBody(params = { "obj", "prop" }, script = "return obj[prop];")
    public static native JSObject getJSObject(JSObject obj, String prop);

    @JSBody(params = { "obj", "prop", "value" }, script = "obj[prop] = value;")
    public static native JSObject setBoolean(JSObject obj, String prop, boolean value);

    @JSBody(params = { "obj", "prop", "value" }, script = "obj[prop] = value;")
    public static native JSObject setString(JSObject obj, String prop, String value);

    @JSBody(params = { "obj", "prop", "value" }, script = "obj[prop] = value;")
    public static native JSObject setDouble(JSObject obj, String prop, double value);

    @JSBody(params = { "obj", "prop", "value" }, script = "obj[prop] = value;")
    public static native JSObject setJavaObject(JSObject obj, String prop, Object value);

    @JSBody(params = { "obj", "prop", "value" }, script = "obj[prop] = value;")
    public static native JSObject setJSObject(JSObject obj, String prop, JSObject value);

    public static JSObject set(JSObject obj, String prop, Object value) {
        if (value == null)
            setJSObject(obj, prop, null);
        else if (value instanceof Boolean b)
            setBoolean(obj, prop, b);
        else if (value instanceof String s)
            setString(obj, prop, s);
        else if (value instanceof Number n)
            setDouble(obj, prop, n.doubleValue());
        else if (value instanceof JSObject jso)
            setJSObject(obj, prop, jso);
        else
            setJavaObject(obj, prop, value);
        return obj;
    }

    @JSBody(params = { "array", "index", "value" }, script = "array[index] = value;")
    public static native JSObject setAt(JSObject array, int index, Object value);

    @JSBody(params = { "array", "index", "value" }, script = "array[index] = value;")
    public static native JSObject setAt(JSObject array, int index, double value);

    @JSBody(params = { "array", "index", "value" }, script = "array[index] = value;")
    public static native JSObject setAt(JSObject array, int index, boolean value);

    @JSBody(params = { "array", "index" }, script = "return array[index];")
    public static native JSObject getAt(JSObject array, int index);

    @JSBody(params = { "value" }, script = "return typeof value === 'number';")
    public static native boolean isNumber(JSObject value);

    public static Object jsToJava(JSObject value) {
        if (value == null || JSObjects.isUndefined(value))
            return null;
        // Check if it's a number and box it properly
        if (isNumber(value)) {
            return jsCastToDouble(value);
        }
        return jsCastToObject(value);
    }

    public static <T> T javaToJs(Object o) {
        if (o == null)
            return null;
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

    @JSBody(params = { "value" }, script = "return value;")
    private static native double jsCastToDouble(JSObject value);

    @JSBody(params = { "value" }, script = "return value;")
    private static native Object jsCastToObject(JSObject value);

    public static Integer getJSInteger(JSObject obj, String... props) {
        JSObject result = getLastJSObject(obj, props);
        return result == null ? null : getJSInteger(result, props[props.length - 1]);
    }

}
