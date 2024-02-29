package dev.webfx.platform.ast.spi.factory.impl.gwt;

import com.google.gwt.core.client.JavaScriptObject;
import dev.webfx.platform.ast.AstArray;
import dev.webfx.platform.ast.AstObject;
import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.spi.factory.nativeast.AstType;
import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstFactoryProvider;

/**
 * @author Bruno Salmon
 */
public final class GwtAstFactoryProvider implements NativeAstFactoryProvider {

    static GwtAstFactoryProvider INSTANCE;

    public GwtAstFactoryProvider() {
        INSTANCE = this;
    }

    @Override
    public Object createNativeObject() {
        return GwtAstObject.create(); // GwtAstObject is both the wrapper and the native object
    }

    @Override
    public Object createNativeArray() {
        return GwtAstArray.create(); // GwtAstArray is both the wrapper and the native array
    }

    @Override
    public boolean acceptAsNativeObject(Object nativeElement) {
        return "object".equals(typeof(nativeElement));
    }

    @Override
    public boolean acceptAsNativeArray(Object nativeElement) {
        return isArray(nativeElement);
    }

    private static native String typeof(Object obj) /*-{
        return typeof obj;
    }-*/;

    private static native boolean isArray(Object obj) /*-{
        return Array.isArray(obj);
    }-*/;

    @Override
    public boolean isAstObjectFromThisFactory(ReadOnlyAstObject astObject) {
        return astObject instanceof GwtAstObject; // TODO: check if it's working
    }

    @Override
    public boolean isAstArrayFromThisFactory(ReadOnlyAstArray astArray) {
        return astArray instanceof GwtAstArray; // TODO: check if it's working
    }

    @Override
    public native Object astToNativeObject(ReadOnlyAstObject astObjectFromThisFactory) /*-{
        return astObjectFromThisFactory;
    }-*/;

    @Override
    public native Object astToNativeArray(ReadOnlyAstArray astArrayFromThisFactory) /*-{
        return astArrayFromThisFactory;
    }-*/;

    @Override
    public native AstObject nativeToAstObject(Object nativeObject) /*-{
        return nativeObject;
    }-*/;

    @Override
    public native AstArray nativeToAstArray(Object nativeArray) /*-{
        return nativeArray;
    }-*/;

    @Override
    public native <T> T nativeScalarToJavaScalar(Object nativeScalar) /*-{
        return nativeScalar;
    }-*/;

    @Override
    public AstType getNativeElementAstType(Object nativeElement) {
        if (nativeElement == null)
            return AstType.NULL;
        if (isArray(nativeElement))
            return AstType.ARRAY;
        switch(typeof(nativeElement)) {
            case "object":  return AstType.OBJECT;
            case "string":  return AstType.STRING;
            case "number":  return AstType.NUMBER;
            case "boolean": return AstType.BOOLEAN;
            default:        return AstType.UNDEFINED;
        }
    }

    @Override
    public Object javaScalarToNativeScalar(Object value) {
        if (value == null)
            return null;
        if (value instanceof Boolean)
            return toJsBoolean((Boolean) value);
        if (value instanceof Number)
            return toJsDouble(((Number) value).doubleValue());
        return value;
    }

    private static native JavaScriptObject toJsBoolean(boolean value) /*-{
        return value;
    }-*/;

    private static native JavaScriptObject toJsDouble(double value) /*-{
        return value;
    }-*/;
}
