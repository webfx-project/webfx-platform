package dev.webfx.platform.ast.spi.factory.impl.teavm;

import dev.webfx.platform.ast.AstArray;
import dev.webfx.platform.ast.AstObject;
import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.spi.factory.nativeast.AstType;
import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstFactoryProvider;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;
import org.teavm.jso.core.JSArray;
import org.teavm.jso.core.JSBoolean;
import org.teavm.jso.core.JSNumber;
import org.teavm.jso.core.JSString;

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
        return newJSObject();
    }

    @Override
    public Object createNativeArray() {
        return JSArray.create();
    }

    @Override
    public boolean acceptAsNativeObject(Object nativeElement) {
        if (nativeElement instanceof TeaVmAstObject)
            return true;
        return nativeElement instanceof JSObject && "object".equals(typeof((JSObject) nativeElement));
    }

    @Override
    public boolean acceptAsNativeArray(Object nativeElement) {
        if (nativeElement instanceof TeaVmAstArray)
            return true;
        return nativeElement instanceof JSObject && isArray((JSObject) nativeElement);
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
        if (nativeObject instanceof TeaVmAstObject)
            return (TeaVmAstObject) nativeObject;
        return TeaVmAstObject.create((JSObject) nativeObject);
    };

    @Override
    public AstArray nativeToAstArray(Object nativeArray) {
        if (nativeArray instanceof TeaVmAstArray)
            return (TeaVmAstArray) nativeArray;
        return TeaVmAstArray.create((JSArray) nativeArray);
    };

    @Override
    public AstType getNativeElementAstType(Object nativeElement) {
        if (nativeElement == null)
            return AstType.NULL;
        JSObject jso = (JSObject) nativeElement;
        switch(typeof(jso)) {
            case "object":  return isArray(jso) ? AstType.ARRAY : AstType.OBJECT;
            case "string":  return AstType.STRING;
            case "number":  return AstType.NUMBER;
            case "boolean": return AstType.BOOLEAN;
            default:        return AstType.UNDEFINED;
        }
    }

    @JSBody(params = "object", script = "return typeof object;")
    static native String typeof(JSObject object);

    @JSBody(params = "object", script = "return Object.prototype.toString.apply(object) === '[object Array]';")
    static native boolean isArray(JSObject object);

    @Override
    public Object javaScalarToNativeScalar(Object scalar) {
        if (scalar == null)
            return null;
        if (scalar instanceof String)
            return JSString.valueOf((String) scalar);
        if (scalar instanceof Boolean)
            return JSBoolean.valueOf((Boolean) scalar);
        if (scalar instanceof Float)
            return JSNumber.valueOf((Float) scalar);
        if (scalar instanceof Double)
            return JSNumber.valueOf((Double) scalar);
        if (scalar instanceof Number)
            return JSNumber.valueOf(((Number) scalar).intValue());
        if (scalar instanceof Character)
            return JSString.valueOf(String.valueOf(scalar));
        return scalar;
    }

    @Override
    public <T> T nativeScalarToJavaScalar(Object nativeScalar) {
        switch (getNativeElementAstType(nativeScalar)) {
            case STRING:  return (T) ((JSString) nativeScalar).stringValue();
            case BOOLEAN: return (T) (Object) ((JSBoolean) nativeScalar).booleanValue();
            case NUMBER:  return (T) js2Number((JSNumber) nativeScalar);
        }
        return (T) nativeScalar;
    }


    /** Static JS utility methods **/

    @JSBody(params = {}, script = "return {};")
    static native JSObject newJSObject();

    static Number js2Number(JSNumber jsn) {
        // No distinction between numbers in javascript
        double d = jsn.doubleValue(); // So we convert into a java double by default
        if (d != Math.floor(d)) // if it has decimals (not a round integer value)
            return d; // we return it as is
        // Casting it as long or it depending on the value
        if (Math.abs(d) > Integer.MAX_VALUE) // If grater than max integer value
            return (long) d; // we cast it as a long
        return (int) d; // otherwise as an int
    }

}
