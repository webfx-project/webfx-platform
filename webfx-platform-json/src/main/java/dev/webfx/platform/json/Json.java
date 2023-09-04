package dev.webfx.platform.json;

import dev.webfx.platform.json.spi.JsonProvider;
import dev.webfx.platform.json.spi.impl.listmap.MapJsonObject;
import dev.webfx.platform.json.tree.JsonAstFactory;
import dev.webfx.platform.util.Strings;
import dev.webfx.platform.util.keyobject.*;
import dev.webfx.platform.util.serviceloader.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public final class Json {

    private Json() {}

    /***************************
     * Factory methods helpers *
     **************************/

    private final static JsonAstFactory JSON_TREE_FACTORY = new JsonAstFactory();

    public static NativeAstFactory getJsonAstFactory() {
        return JSON_TREE_FACTORY;
    }

    public static JsonObject createObject() {
        return getProvider().createJsonObject();
    }

    public static <NO> JsonObject createObject(NO nativeObject) {
        return getProvider().nativeToJavaJsonObject(nativeObject);
    }

    public static JsonArray createArray() {
        return getProvider().createJsonArray();
    }

    public static <NA> JsonArray createArray(NA nativeArray) {
        return getProvider().nativeToJavaJsonArray(nativeArray);
    }

    public static JsonObject parseObject(String text) {
        return getProvider().parseObject(text);
    }

    public static JsonObject parseObjectSilently(String text) {
        try {
            return parseObject(text);
        } catch (Exception e) {
            return null;
        }
    }

    public static JsonArray parseArray(String text) {
        return getProvider().parseArray(text);
    }

    public static JsonArray parseArraySilently(String text) {
        try {
            return parseArray(text);
        } catch (Exception e) {
            return null;
        }
    }

    public static JsonElement parseElement(String text) {
        return text.trim().startsWith("[") ? parseArray(text) : parseObject(text);
    }

    public static JsonElement parseElementSilently(String text) {
        return text.trim().startsWith("[") ? parseArraySilently(text) : parseObjectSilently(text);
    }

    public static Object javaToNativeScalar(Object scalar) {
        return getProvider().javaToNativeScalar(scalar);
    }

    public static Object nativeToJavaScalar(Object nativeScalar) {
        return getProvider().nativeToJavaScalar(nativeScalar);
    }


    private static JsonProvider PROVIDER;

    public static void registerProvider(JsonProvider provider) {
        PROVIDER = provider;
    }

    private static JsonProvider getProvider() {
        if (PROVIDER == null) {
            registerProvider(SingleServiceProvider.getProvider(JsonProvider.class, () -> ServiceLoader.load(JsonProvider.class), SingleServiceProvider.NotFoundPolicy.TRACE_AND_RETURN_NULL));
            if (PROVIDER == null) {
                System.out.println("Using default built-in JSON factory which is not interoperable with the underlying platform! Be sure you haven't forgot to call Json.registerProvider().");
                PROVIDER = new MapJsonObject();
            }
        }
        return PROVIDER;
    }

    /***********************************
     * Java conversion methods helpers *
     **********************************/

    public static <T> JsonArray fromJavaArray(T[] javaArray) {
        if (javaArray == null)
            return null;
        JsonArray valuesArray = createArray();
        for (Object javaValue : javaArray)
            valuesArray.push(javaValue);
        return valuesArray;
    }

    public static Object[] toJavaArray(ReadOnlyJsonArray jsonArray) {
        if (jsonArray == null)
            return null;
        int length = jsonArray.size();
        Object[] javaArray = new Object[length];
        for (int i = 0; i < length; i++)
            javaArray[i] = jsonArray.getElement(i);
        return javaArray;
    }

    public static String toJsonString(Object nativeElement) {
        return JsonFormatter.appendNativeElement(nativeElement, Json.getProvider(), new StringBuilder()).toString();
    }

    public static JsonObject mergeInto(ReadOnlyJsonObject src, JsonObject dst) {
        return mergeInto(src, dst, src.keys());
    }

    public static JsonObject mergeInto(ReadOnlyKeyObject src, JsonObject dst, ReadOnlyIndexedArray keys) {
        for (int i = 0, size = keys.size(); i < size; i++) {
            String key = keys.getString(i);
            Object value = src.get(key);
            dst.setNativeElement(key, value);
        }
        return dst;
    }

    public static String lookupString(ReadOnlyJsonObject json, String jsonPath) {
        if (json == null)
            return null;
        String[] paths = Strings.split(jsonPath, ".");
        json = lookupObject(json, paths, true);
        return json == null ? null : json.getString(paths[paths.length - 1]);
    }

    public static ReadOnlyJsonObject lookupObject(ReadOnlyJsonObject json, String jsonPath) {
        if (json == null)
            return null;
        String[] paths = Strings.split(jsonPath, ".");
        return lookupObject(json, paths, false);
    }

    private static ReadOnlyJsonObject lookupObject(ReadOnlyJsonObject json, String[] paths, boolean ignoreLastPath) {
        int n = paths.length;
        if (ignoreLastPath)
            n--;
        for (int i = 0; i < n; i++) {
            json = json.getObject(paths[i]);
            if (json == null)
                return null;
        }
        return json;
    }

}
