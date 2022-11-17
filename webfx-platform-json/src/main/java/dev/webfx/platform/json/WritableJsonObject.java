package dev.webfx.platform.json;

import dev.webfx.platform.util.noreflect.IndexedArray;
import dev.webfx.platform.util.noreflect.KeyObject;
import dev.webfx.platform.util.noreflect.WritableKeyObject;

import java.time.Instant;

/**
 * @author Bruno Salmon
 */
public interface WritableJsonObject extends JsonObject, WritableJsonElement, WritableKeyObject {

    @Override
    default WritableJsonObject getObject(String key) {
        return (WritableJsonObject) JsonObject.super.getObject(key);
    }

    /**
     * Set a given key to the given element. Fluent API (return this).
     */
    WritableJsonObject setNativeElement(String key, Object element);

    /**
     * Set a given key to the given value.
     */
    default WritableJsonObject set(String key, Object value) {
        return setNativeElement(key, anyJavaToNative(value));
    }

    /**
     * Set a given key to the given object.
     */
    default WritableJsonObject setObject(String key, KeyObject object) { return setNativeElement(key, javaToNativeJsonObject((JsonObject) object)); }

    /**
     * Set a given key to the given array.
     */
    default WritableJsonObject setArray(String key, IndexedArray array) { return setNativeElement(key, javaToNativeJsonArray((JsonArray) array)); }

    /**
     * Set a given key to the given element.
     */
    default WritableJsonObject setScalar(String key, Object scalar) { return setNativeElement(key, javaToNativeScalar(scalar)); }

    @Override
    default WritableJsonObject set(String key, Boolean value) {
        return WritableKeyObject.super.set(key, value);
    }

    @Override
    default WritableJsonObject set(String key, Integer value) {
        return WritableKeyObject.super.set(key, value);
    }

    @Override
    default WritableJsonObject set(String key, Long value) {
        return WritableKeyObject.super.set(key, value);
    }

    @Override
    default WritableJsonObject set(String key, Double value) {
        return WritableKeyObject.super.set(key, value);
    }

    @Override
    default WritableJsonObject set(String key, String value) {
        return WritableKeyObject.super.set(key, value);
    }

    @Override
    default WritableJsonObject set(String key, Instant value) {
        return WritableKeyObject.super.set(key, value);
    }
}
