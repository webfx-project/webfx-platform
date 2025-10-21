package dev.webfx.platform.ast.spi.factory.impl.teavm;

import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstArray;
import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstFactoryProvider;
import dev.webfx.platform.util.teavm.TeaVmUtil;
import org.teavm.jso.JSObject;
import org.teavm.jso.core.JSArray;

/**
 * TeaVM implementation of NativeAstArray.
 *
 * @author Bruno Salmon
 */
final class TeaVmAstArray extends TeaVmAstNode implements NativeAstArray {

    public static TeaVmAstArray create(JSArray<?> jsArray) {
        if (jsArray == null || isUndefined(jsArray))
            return null;
        return new TeaVmAstArray(jsArray);
    }

    @Override
    public NativeAstFactoryProvider getProvider() {
        return TeaVmAstFactoryProvider.INSTANCE;
    }

    TeaVmAstArray(JSArray<?> jsArray) {
        super(jsArray);
    }

    <T extends JSObject> JSArray<T> asJSArray() { return (JSArray<T>) nativeElement; }

    @Override
    public JSObject getNativeElement(int index) {
        return TeaVmUtil.getAt(nativeElement, index);
    }

    @Override
    public void setNativeElement(int index, Object value) {
        TeaVmUtil.setAt(nativeElement, index, value);
    }

    public int indexOfNativeElement(Object element) {
        return indexOf(asJSArray(), (JSObject) element);
    }

    @Override
    public void clear() {
        asJSArray().setLength(0);
    }

    @Override
    public int size() {
        return asJSArray().getLength();
    }

    @Override
    public void pushNativeElement(Object element) {
        asJSArray().push((JSObject) element);
    }

    @Override
    public <T> T remove(int index) {
        return (T) asJSArray().splice(index, 1).get(0);
    }

}