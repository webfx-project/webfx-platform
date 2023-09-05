package dev.webfx.platform.json;

import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.AstObject;

import java.time.Instant;

/**
 * @author Bruno Salmon
 */
public interface JsonObject extends ReadOnlyJsonObject, JsonElement, AstObject {

    @Override
    default JsonObject getObject(String key) {
        return (JsonObject) ReadOnlyJsonObject.super.getObject(key);
    }

    /**
     * Set a given key to the given element. Fluent API (return this).
     */
    JsonObject setNativeElement(String key, Object element);

    /**
     * Set a given key to the given value.
     */
    default JsonObject set(String key, Object value) {
        return setNativeElement(key, anyJavaToNative(value));
    }

    /**
     * Set a given key to the given object.
     */
    default JsonObject setObject(String key, ReadOnlyAstObject object) { return setNativeElement(key, javaToNativeJsonObject((ReadOnlyJsonObject) object)); }

    /**
     * Set a given key to the given array.
     */
    default JsonObject setArray(String key, ReadOnlyAstArray array) { return setNativeElement(key, javaToNativeJsonArray((ReadOnlyJsonArray) array)); }

    /**
     * Set a given key to the given element.
     */
    default JsonObject setScalar(String key, Object scalar) { return setNativeElement(key, javaToNativeScalar(scalar)); }

    @Override
    default JsonObject set(String key, Boolean value) {
        return AstObject.super.set(key, value);
    }

    @Override
    default JsonObject set(String key, Integer value) {
        return AstObject.super.set(key, value);
    }

    @Override
    default JsonObject set(String key, Long value) {
        return AstObject.super.set(key, value);
    }

    @Override
    default JsonObject set(String key, Double value) {
        return AstObject.super.set(key, value);
    }

    @Override
    default JsonObject set(String key, String value) {
        return AstObject.super.set(key, value);
    }

    @Override
    default JsonObject set(String key, Instant value) {
        return AstObject.super.set(key, value);
    }
}
