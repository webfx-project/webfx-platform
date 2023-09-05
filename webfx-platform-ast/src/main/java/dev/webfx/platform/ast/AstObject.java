package dev.webfx.platform.ast;

import dev.webfx.platform.util.Dates;

import java.time.Instant;

/**
 * @author Bruno Salmon
 */
public interface AstObject extends ReadOnlyAstObject {

    @Override
    default AstObject getObject(String key) {
        return (AstObject) ReadOnlyAstObject.super.getObject(key);
    }

    /**
     * Remove a given key and associated value from the object.
     */
    <V> V remove(String key);

    /**
     * Set a given key to the given value.
     */
    <T extends AstObject> T set(String key, Object value);

    /**
     * Set a given key to the given object.
     */
    default <T extends AstObject> T setObject(String key, ReadOnlyAstObject object) { return set(key, object); }

    /**
     * Set a given key to the given array.
     */
    default <T extends AstObject> T setArray(String key, ReadOnlyAstArray array) { return set(key, array); }

    /**
     * Set a given key to the given element.
     */
    default <T extends AstObject> T setScalar(String key, Object scalar) { return set(key, scalar); }

    default <T extends AstObject> T set(String key, Boolean value) { return setScalar(key, value); }

    default <T extends AstObject> T set(String key, Integer value) { return setScalar(key, value); }

    default <T extends AstObject> T set(String key, Long value) { return setScalar(key, value); }

    default <T extends AstObject> T set(String key, Double value) { return setScalar(key, value); }

    default <T extends AstObject> T set(String key, String value) { return setScalar(key, value); }

    default <T extends AstObject> T set(String key, Instant value) { return setScalar(key, Dates.formatIso(value)); }

}
