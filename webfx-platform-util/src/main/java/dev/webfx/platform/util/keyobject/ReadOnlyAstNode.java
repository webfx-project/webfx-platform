package dev.webfx.platform.util.keyobject;


/**
 * Generic interface common to both objects and arrays.
 *
 * @author Bruno Salmon
 */
public interface ReadOnlyAstNode {

    default boolean isObject() {
        return this instanceof ReadOnlyKeyObject;
    }

    default boolean isArray() {
        return this instanceof ReadOnlyIndexedArray;
    }

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

}
