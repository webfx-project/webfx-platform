package dev.webfx.platform.ast;


/**
 * Generic interface common to both objects and arrays.
 *
 * @author Bruno Salmon
 */
public interface ReadOnlyAstNode {

    default boolean isObject() {
        return this instanceof ReadOnlyAstObject;
    }

    default boolean isArray() {
        return this instanceof ReadOnlyAstArray;
    }

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

}
