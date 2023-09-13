package dev.webfx.platform.json;

import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;

/**
 * @author Bruno Salmon
 */
public interface ReadOnlyJsonObject extends ReadOnlyKeyObject, ReadOnlyJsonElement {

    /**
     * All keys of the object.
     */
    ReadOnlyJsonArray keys();

    /**
     * Return the element as it is stored (unwrapped) in the underlying structure (so either a value or an unwrapped object/array).
     */
    Object getNativeElement(String key);

    /**
     * Return the element as a value or wrapped object/array.
     */
    default <T> T get(String key) { return anyNativeToJava(getNativeElement(key)); }

    /**
     * Return the element as a JsonObject. If the type is not an object, this can result in runtime errors.
     */
    default ReadOnlyJsonObject getObject(String key) { return nativeToJavaJsonObject(getNativeElement(key)); }

    /**
     * Return the element as a JsonArray. If the type is not an array, this can result in runtime errors.
     */
    default ReadOnlyJsonArray getArray(String key) { return nativeToJavaJsonArray(getNativeElement(key)); }

    default <T> T getScalar(String key) {
        return nativeToJavaScalar(getNativeElement(key));
    }
}