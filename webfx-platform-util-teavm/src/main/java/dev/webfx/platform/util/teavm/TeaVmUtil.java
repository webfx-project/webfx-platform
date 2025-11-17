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

    public static Object jsToJava(JSObject value) {
        if (value == null || JSObjects.isUndefined(value))
            return null;
        // Check if it's a number and box it properly
        return switch (JSObjects.typeOf(value)) {
            case "number" -> jsCastToDouble(value);
            case "boolean" -> jsCastToBoolean(value);
            case "string" -> jsCastToString(value);
            default -> jsCastToObject(value);
        };
    }

    public static Object javaToJs(Object value) {
        if (value == null || JSObjects.isUndefined(value))
            return null;
        if (value instanceof JSObject)
            return value;
        if (value instanceof String s)
            return JSString.valueOf(s);
        if (value instanceof Number n) {
            if (n instanceof Double)
                return JSNumber.valueOf(n.doubleValue());
            if (n instanceof Float)
                return JSNumber.valueOf(n.floatValue());
            return JSNumber.valueOf(n.intValue());
        }
        if (value instanceof Boolean b)
            return JSBoolean.valueOf(b);
        if (value instanceof Character c)
            return JSString.valueOf(String.valueOf(c));
        return value;
    }


    @JSBody(params = { "value" }, script = "return value;")
    private static native boolean jsCastToBoolean(JSObject value);

    @JSBody(params = { "value" }, script = "return value;")
    private static native double jsCastToDouble(JSObject value);

    @JSBody(params = { "value" }, script = "return value;")
    private static native String jsCastToString(JSObject value);

    @JSBody(params = { "value" }, script = "return value;")
    private static native Object jsCastToObject(JSObject value);

}
