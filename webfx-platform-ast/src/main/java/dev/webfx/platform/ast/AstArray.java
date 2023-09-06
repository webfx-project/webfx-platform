package dev.webfx.platform.ast;

/**
 * @author Bruno Salmon
 */
public interface AstArray extends ReadOnlyAstArray {

    /**
     * Remove a given index and associated value from the object.
     */
    <V> V remove(int index);

    /**
     * Pushes the given element onto the end of the array. Most consuming call.
     */
    <T extends AstArray> T push(Object element);

    /**
     * Set a given index to the given object.
     */
    default <T extends AstArray> T push(ReadOnlyAstObject object) { return push((Object) object); }

    /**
     * Set a given index to the given array.
     */
    default <T extends AstArray> T push(ReadOnlyAstArray array) { return push((Object) array); }

    /**
     * Set a given index to the given element.
     */
    default <T extends AstArray> T pushScalar(Object scalar) { return push(scalar); }

    /**
     * Pushes the given boolean string onto the end of the array.
     */
    default <T extends AstArray> T push(String value) { return pushScalar(value); }

    /**
     * Pushes the given boolean value onto the end of the array.
     */
    default <T extends AstArray> T push(boolean value) { return pushScalar(value); }

    /**
     * Pushes the given double value onto the end of the array.
     */
    default <T extends AstArray> T push(double value) { return pushScalar(value); }

    /**
     * Set a given index to the given value. Most consuming call.
     */
    <T extends AstArray> T set(int index, Object value);

    /**
     * Set a given index to the given object.
     */
    default <T extends AstArray> T set(int index, ReadOnlyAstObject object) {
        return set(index, (Object) object);
    }

    /**
     * Set a given index to the given array.
     */
    default <T extends AstArray> T set(int index, ReadOnlyAstArray array) {
        return set(index, (Object) array);
    }

    /**
     * Set a given index to the given scalar.
     */
    default <T extends AstArray> T setScalar(int index, Object scalar) {
        return set(index, scalar);
    }

    /**
     * Set a given index to the given string.
     */
    default <T extends AstArray> T set(int index, String value) {
        return setScalar(index, value);
    }

    /**
     * Set a given index to the given boolean.
     */
    default <T extends AstArray> T set(int index, Boolean value) {
        return setScalar(index, value);
    }

    /**
     * Set a given index to the given double.
     */
    default <T extends AstArray> T set(int index, Double value) {
        return setScalar(index, value);
    }


}
