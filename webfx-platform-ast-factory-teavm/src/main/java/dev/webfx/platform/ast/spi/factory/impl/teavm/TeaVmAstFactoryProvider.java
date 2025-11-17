package dev.webfx.platform.ast.spi.factory.impl.teavm;

import dev.webfx.platform.ast.AstArray;
import dev.webfx.platform.ast.AstObject;
import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.spi.factory.nativeast.AstType;
import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstFactoryProvider;
import dev.webfx.platform.util.teavm.TeaVmUtil;
import org.teavm.jso.JSObject;
import org.teavm.jso.core.*;
import org.teavm.jso.impl.JSWrapper;

/**
 * @author Bruno Salmon
 */
public final class TeaVmAstFactoryProvider implements NativeAstFactoryProvider {

    static TeaVmAstFactoryProvider INSTANCE;

    public TeaVmAstFactoryProvider() {
        INSTANCE = this;
    }

    @Override
    public Object createNativeObject() {
        return JSObjects.create();
    }

    @Override
    public Object createNativeArray() {
        return new JSArray<>();
    }

    @Override
    public boolean acceptAsNativeObject(Object nativeElement) {
        if (nativeElement instanceof TeaVmAstObject)
            return true;
        return nativeElement instanceof JSObject jso && "object".equals(JSObjects.typeOf(jso));
    }

    @Override
    public boolean acceptAsNativeArray(Object nativeElement) {
        if (nativeElement instanceof TeaVmAstArray)
            return true;
        return nativeElement instanceof JSObject jso && JSArray.isArray(jso);
    }

    @Override
    public boolean isAstObjectFromThisFactory(ReadOnlyAstObject astObject) {
        return astObject instanceof TeaVmAstObject;
    }

    @Override
    public boolean isAstArrayFromThisFactory(ReadOnlyAstArray astArray) {
        return astArray instanceof TeaVmAstArray;
    }

    @Override
    public Object astToNativeObject(ReadOnlyAstObject astObjectFromThisFactory) {
        return ((TeaVmAstNode) astObjectFromThisFactory).getNativeElement();
    }

    @Override
    public Object astToNativeArray(ReadOnlyAstArray astArrayFromThisFactory) {
        return ((TeaVmAstNode) astArrayFromThisFactory).getNativeElement();
    }

    @Override
    public AstObject nativeToAstObject(Object nativeObject) {
        return TeaVmAstObject.create(JSWrapper.javaToJs(nativeObject));
    }

    @Override
    public AstArray nativeToAstArray(Object nativeArray) {
        return TeaVmAstArray.create((JSArray<?>) JSWrapper.javaToJs(nativeArray));
    }

    @Override
    public AstType getNativeElementAstType(Object nativeElement) {
        if (nativeElement == null)
            return AstType.NULL;
        if (nativeElement instanceof JSObject jso) {
            return switch (JSObjects.typeOf(jso)) {
                case "object" -> JSArray.isArray(jso) ? AstType.ARRAY : AstType.OBJECT;
                case "string" -> AstType.STRING;
                case "number" -> AstType.NUMBER;
                case "boolean" -> AstType.BOOLEAN;
                default -> AstType.UNDEFINED;
            };
        }
        return AstType.UNDEFINED;
    }

    @Override
    public Object javaScalarToNativeScalar(Object scalar) {
        return TeaVmUtil.javaToJs(scalar);
    }

    @Override
    public <T> T nativeScalarToJavaScalar(Object nativeScalar) {
        if (nativeScalar instanceof JSObject jsObject)
            return (T) TeaVmUtil.jsToJava(jsObject);
        return (T) nativeScalar;
    }
}
