package dev.webfx.platform.ast.json;

import dev.webfx.platform.ast.ReadOnlyAstArray;

/**
 * @author Bruno Salmon
 */
public interface ReadOnlyJsonArray extends ReadOnlyJsonElement, ReadOnlyAstArray {

    /**
     * Returns the first index of the given element, or -1 if it cannot be found.
     */
    int indexOfNativeElement(Object element);

    /**
     * Returns the first index of the given value, or -1 if it cannot be found.
     */
    default int indexOf(Object value) {
        return indexOfNativeElement(anyJavaToNative(value));
    }

    /**
     * Return the ith element of the array.
     */
    Object getNativeElement(int index);

    /**
     * Return the ith element of the array. Most consuming call.
     */
    default <V> V getElement(int index) {
        return anyNativeToJava(getNativeElement(index));
    }

    /**
     * Return the ith element of the array as a JsonObject. If the type is not an object, this can result in runtime errors.
     */
    default ReadOnlyJsonObject getObject(int index) { return nativeToJavaJsonObject(getNativeElement(index)); }

    /**
     * Return the ith element of the array as a JsonArray. If the type is not an array, this can result in runtime errors.
     */
    default ReadOnlyJsonArray getArray(int index) { return nativeToJavaJsonArray(getNativeElement(index)); }

    default <T> T getScalar(int index) {
        return nativeToJavaScalar(getNativeElement(index));
    }
}
