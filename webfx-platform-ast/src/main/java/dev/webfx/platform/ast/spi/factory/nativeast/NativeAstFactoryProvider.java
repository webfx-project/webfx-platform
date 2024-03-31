package dev.webfx.platform.ast.spi.factory.nativeast;

import dev.webfx.platform.ast.AstArray;
import dev.webfx.platform.ast.AstObject;
import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.spi.factory.AstFactoryProvider;
import dev.webfx.platform.util.Numbers;

/**
 * @author Bruno Salmon
 */
public interface NativeAstFactoryProvider extends AstFactoryProvider {

    Object createNativeObject();

    Object createNativeArray();

    boolean acceptAsNativeObject(Object nativeElement);

    boolean acceptAsNativeArray(Object nativeElement);

    @Override
    default AstObject createObject() {
        return nativeToAstObject(createNativeObject());
    }

    default AstArray createArray() {
        return nativeToAstArray(createNativeArray());
    }

    boolean isAstObjectFromThisFactory(ReadOnlyAstObject astObject);

    boolean isAstArrayFromThisFactory(ReadOnlyAstArray astArray);

    Object astToNativeObject(ReadOnlyAstObject astObjectFromThisFactory);

    Object astToNativeArray(ReadOnlyAstArray astArrayFromThisFactory);

    AstObject nativeToAstObject(Object nativeObject);

    AstArray nativeToAstArray(Object nativeArray);

    default ReadOnlyAstObject nativeToReadOnlyAstObject(Object nativeObject) {
        if (nativeObject instanceof ReadOnlyAstObject)
            return (ReadOnlyAstObject) nativeObject;
        return nativeToAstObject(nativeObject);
    }

    default ReadOnlyAstArray nativeToReadOnlyAstArray(Object nativeArray) {
        if (nativeArray instanceof ReadOnlyAstArray)
            return (ReadOnlyAstArray) nativeArray;
        return nativeToAstArray(nativeArray);
    }

    default AstType getNativeElementAstType(Object nativeElement) {
        if (nativeElement == null)
            return AstType.NULL;
        if (acceptAsNativeObject(nativeElement))
            return AstType.OBJECT;
        if (acceptAsNativeArray(nativeElement))
            return AstType.ARRAY;
        if (nativeElement instanceof Boolean)
            return AstType.NUMBER;
        if (nativeElement instanceof String)
            return AstType.STRING;
        if (Numbers.isNumber(nativeElement))
            return AstType.NUMBER;
        return AstType.UNDEFINED;
    }

    default <T> T anyNativeToJava(Object nativeElement) {
        switch (getNativeElementAstType(nativeElement)) {
            case STRING:
            case BOOLEAN:
            case NUMBER: return nativeScalarToJavaScalar(nativeElement);
            case ARRAY:  return (T) nativeToAstArray(nativeElement);
            case OBJECT: return (T) nativeToAstObject(nativeElement);
            default:     return (T) nativeElement;
        }
    }

    default <T> T nativeScalarToJavaScalar(Object nativeScalar) { return (T) nativeScalar; }

    default Object anyJavaToAnyNative(Object value) {
        if (value == null)
            return null;
        if (value instanceof ReadOnlyAstArray)
            return astToNativeArray((ReadOnlyAstArray) value);
        if (value instanceof ReadOnlyAstObject)
            return astToNativeObject((ReadOnlyAstObject) value);
        return javaScalarToNativeScalar(value);
    }

    default Object javaScalarToNativeScalar(Object scalar) { return scalar; }

}
