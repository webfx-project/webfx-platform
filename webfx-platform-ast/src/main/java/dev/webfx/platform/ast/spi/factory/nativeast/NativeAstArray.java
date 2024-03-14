package dev.webfx.platform.ast.spi.factory.nativeast;

import dev.webfx.platform.ast.AstArray;
import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;

/**
 * @author Bruno Salmon
 */
public interface NativeAstArray extends AstArray {

    NativeAstFactoryProvider getProvider();

    /**
     * Returns the first index of the given element, or -1 if it cannot be found.
     */
    int indexOfNativeElement(Object element);

    /**
     * Returns the first index of the given value, or -1 if it cannot be found.
     */
    default int indexOf(Object value) {
        return indexOfNativeElement(getProvider().anyJavaToAnyNative(value));
    }

    /**
     * Return the ith element of the array.
     */
    Object getNativeElement(int index);

    /**
     * Return the ith element of the array. Most consuming call.
     */
    default <V> V getElement(int index) {
        return getProvider().anyNativeToJava(getNativeElement(index));
    }

    /**
     * Return the ith element of the array as a JsonObject. If the type is not an object, this can result in runtime errors.
     */
    default ReadOnlyAstObject getObject(int index) { return getProvider().nativeToAstObject(getNativeElement(index)); }

    /**
     * Return the ith element of the array as a JsonArray. If the type is not an array, this can result in runtime errors.
     */
    default ReadOnlyAstArray getArray(int index) { return getProvider().nativeToAstArray(getNativeElement(index)); }


    default <T> T getScalar(int index) {
        return getProvider().nativeScalarToJavaScalar(getNativeElement(index));
    }

    /**
     * Pushes the given element onto the end of the array. Fluent API (return this).
     */
    void pushNativeElement(Object element);

    /**
     * Set a given index to the given value. Fluent API (return this).
     */
    void setNativeElement(int index, Object value);


    /**
     * Pushes the given element onto the end of the array. Most consuming call.
     */
    default NativeAstArray push(Object element) {
        pushNativeElement(getProvider().anyJavaToAnyNative(element));
        return this;
    }

    /**
     * Set a given index to the given object.
     */
    default NativeAstArray push(ReadOnlyAstObject object) {
        pushNativeElement(getProvider().astToNativeObject(object));
        return this;
    }

    /**
     * Set a given index to the given array.
     */
    default NativeAstArray push(ReadOnlyAstArray array) {
        pushNativeElement(getProvider().astToNativeArray(array));
        return this;
    }

    /**
     * Set a given index to the given element.
     */
    default NativeAstArray pushScalar(Object scalar) {
        pushNativeElement(getProvider().javaScalarToNativeScalar(scalar));
        return this;
    }


    /**
     * Set a given index to the given value. Most consuming call.
     */
    default NativeAstArray set(int index, Object value) {
        setNativeElement(index, getProvider().anyJavaToAnyNative(value));
        return this;
    }

    /**
     * Set a given index to the given object.
     */
    default NativeAstArray set(int index, ReadOnlyAstObject object) {
        setNativeElement(index, getProvider().astToNativeObject(object));
        return this;
    }

    /**
     * Set a given index to the given array.
     */
    default NativeAstArray set(int index, ReadOnlyAstArray array) {
        setNativeElement(index, getProvider().nativeToAstArray(array));
        return this;
    }

    /**
     * Set a given index to the given scalar.
     */
    default NativeAstArray setScalar(int index, Object scalar) {
        setNativeElement(index, getProvider().javaScalarToNativeScalar(scalar));
        return this;
    }


}
