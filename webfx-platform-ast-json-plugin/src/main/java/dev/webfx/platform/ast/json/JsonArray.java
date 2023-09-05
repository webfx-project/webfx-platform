package dev.webfx.platform.ast.json;

import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.AstArray;

/**
 * @author Bruno Salmon
 */
public interface JsonArray extends ReadOnlyJsonArray, JsonElement, AstArray {

    /**
     * Pushes the given element onto the end of the array. Fluent API (return this).
     */
    JsonArray pushNativeElement(Object element);

    /**
     * Pushes the given element onto the end of the array. Most consuming call.
     */
    default JsonArray push(Object element) {
        return pushNativeElement(anyJavaToNative(element));
    }

    /**
     * Set a given index to the given object.
     */
    default JsonArray push(ReadOnlyAstObject object) { return pushNativeElement(javaToNativeJsonObject((ReadOnlyJsonObject) object)); }

    /**
     * Set a given index to the given array.
     */
    default JsonArray push(ReadOnlyAstArray array) { return pushNativeElement(javaToNativeJsonArray((ReadOnlyJsonArray) array)); }

    /**
     * Set a given index to the given element.
     */
    default JsonArray pushScalar(Object scalar) { return pushNativeElement(javaToNativeScalar(scalar)); }


    /**
     * Set a given index to the given value. Fluent API (return this).
     */
    JsonArray setNativeElement(int index, Object value);

    /**
     * Set a given index to the given value. Most consuming call.
     */
    default JsonArray set(int index, Object value) {
        return setNativeElement(index, anyJavaToNative(value));
    }

    /**
     * Set a given index to the given object.
     */
    default JsonArray set(int index, ReadOnlyJsonObject object) {
        return setNativeElement(index, javaToNativeJsonObject(object));
    }

    /**
     * Set a given index to the given array.
     */
    default JsonArray set(int index, ReadOnlyJsonArray array) {
        return setNativeElement(index, javaToNativeJsonArray(array));
    }

    /**
     * Set a given index to the given scalar.
     */
    default JsonArray setScalar(int index, Object scalar) {
        return setNativeElement(index, javaToNativeScalar(scalar));
    }
}
