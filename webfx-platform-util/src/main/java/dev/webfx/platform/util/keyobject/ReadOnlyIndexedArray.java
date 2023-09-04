package dev.webfx.platform.util.keyobject;

import dev.webfx.platform.util.Booleans;
import dev.webfx.platform.util.Numbers;
import dev.webfx.platform.util.Objects;
import dev.webfx.platform.util.Strings;

import java.util.Iterator;

/**
 * @author Bruno Salmon
 */
public interface ReadOnlyIndexedArray extends ReadOnlyAstNode, Iterable<Object> {

    /**
     * Length of the array or number of keys of the object
     */
    int size();

    /**
     * Returns the first index of the given value, or -1 if it cannot be found.
     */
    int indexOf(Object value);

    /**
     * Return the ith element of the array. Most consuming call.
     */
    <V> V getElement(int index);

    default boolean isNull(int index) {
        return getElement(index) == null;
    }

    default boolean isObject(int index) {
        return getElement(index) instanceof ReadOnlyKeyObject;
    }

    default boolean isArray(int index) {
        return getElement(index) instanceof ReadOnlyIndexedArray;
    }

    default boolean isScalar(int index) {
        return !isNull(index) && !isObject(index) && !isArray(index);
    }

    /**
     * Return the ith element of the array as a JsonObject. If the type is not an object, this can result in runtime errors.
     */
    default ReadOnlyKeyObject getObject(int index) { return getElement(index); }

    /**
     * Return the ith element of the array as a JsonArray. If the type is not an array, this can result in runtime errors.
     */
    default ReadOnlyIndexedArray getArray(int index) { return getElement(index); }

    default <T> T getScalar(int index) {
        return getElement(index);
    }

    default <T> T getScalar(int index, T defaultValue) {
        return Objects.coalesce(getScalar(index), defaultValue);
    }

    /**
     * Return the ith element of the array as a boolean. If the type is not a boolean, this can result in runtime errors.
     */
    default Boolean getBoolean(int index) { return Booleans.toBoolean(getScalar(index)); }

    /**
     * Return the ith element of the array as a boolean. If the type is not a boolean, this can result in runtime errors.
     */
    default Boolean getBoolean(int index, Boolean defaultValue) { return Booleans.toBoolean(getScalar(index, defaultValue)); }

    /**
     * Return the ith element of the array as a String. If the type is not a String, this can result in runtime errors.
     */
    default String getString(int index) { return Strings.toString(getScalar(index)); }

    /**
     * Return the ith element of the array as a String. If the type is not a String, this can result in runtime errors.
     */
    default String getString(int index, String defaultValue) { return Strings.toString(getScalar(index, defaultValue)); }

    /**
     * Return the ith element of the array as a int. If the type is not a int, this can result in runtime errors.
     */
    default Integer getInteger(int index) { return Numbers.toInteger(getScalar(index)); }

    /**
     * Return the ith element of the array as a int. If the type is not a int, this can result in runtime errors.
     */
    default Integer getInteger(int index, Integer defaultValue) { return Numbers.toInteger(getScalar(index, defaultValue)); }

    /**
     * Return the ith element of the array as a long. If the type is not a long, this can result in runtime errors.
     */
    default Long getLong(int index) { return Numbers.longValue(getScalar(index)); }

    /**
     * Return the ith element of the array as a long. If the type is not a long, this can result in runtime errors.
     */
    default Long getLong(int index, Long defaultValue) { return Numbers.toLong(getScalar(index, defaultValue)); }

    /**
     * Return the ith element of the array as a double. If the type is not a double, this can result in runtime errors.
     */
    default Double getDouble(int index) { return Numbers.toDouble(getScalar(index)); }

    /**
     * Return the ith element of the array as a double. If the type is not a double, this can result in runtime errors.
     */
    default Double getDouble(int index, Double defaultValue) { return Numbers.toDouble(getScalar(index, defaultValue)); }


    @Override
    default Iterator<Object> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public Object next() {
                return getElement(index++);
            }
        };
    }

}
