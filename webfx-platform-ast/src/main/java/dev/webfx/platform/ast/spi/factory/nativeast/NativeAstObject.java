package dev.webfx.platform.ast.spi.factory.nativeast;

import dev.webfx.platform.ast.AstArray;
import dev.webfx.platform.ast.AstObject;
import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;

/**
 * @author Bruno Salmon
 */
public interface NativeAstObject extends AstObject {

    NativeAstFactoryProvider getProvider();

    /**
     * Return the element as it is stored (unwrapped) in the underlying structure (so either a value or an unwrapped object/array).
     */
    Object getNativeElement(String key);

    /**
     * Return the element as a value or wrapped object/array.
     */
    default <T> T get(String key) { return getProvider().anyNativeToJava(getNativeElement(key)); }

    /**
     * Return the element as a JsonObject. If the type is not an object, this can result in runtime errors.
     */
    default AstObject getObject(String key) { return getProvider().nativeToAstObject(getNativeElement(key)); }

    /**
     * Return the element as a JsonArray. If the type is not an array, this can result in runtime errors.
     */
    default AstArray getArray(String key) { return getProvider().nativeToAstArray(getNativeElement(key)); }

    default <T> T getScalar(String key) {
        return getProvider().nativeScalarToJavaScalar(getNativeElement(key));
    }

    /**
     * Set a given key to the given element. Fluent API (return this).
     */
    void setNativeElement(String key, Object element);

    /**
     * Set a given key to the given value.
     */
    default <T extends AstObject> T set(String key, Object value) {
        setNativeElement(key, getProvider().anyJavaToAnyNative(value));
        return (T) this;
    }

    /**
     * Set a given key to the given object.
     */
    default <T extends AstObject> T setObject(String key, ReadOnlyAstObject object) {
        setNativeElement(key, getProvider().astToNativeObject(object));
        return (T) this;
    }

    /**
     * Set a given key to the given array.
     */
    default <T extends AstObject> T setArray(String key, ReadOnlyAstArray array) {
        setNativeElement(key, getProvider().astToNativeArray(array));
        return (T) this;
    }

    /**
     * Set a given key to the given element.
     */
    default <T extends AstObject> T setScalar(String key, Object scalar) {
        setNativeElement(key, getProvider().javaScalarToNativeScalar(scalar));
        return (T) this;
    }

}
