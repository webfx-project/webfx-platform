package dev.webfx.platform.ast.spi.factory.impl.teavm;

import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstFactoryProvider;
import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstObject;
import org.teavm.jso.JSObject;
import org.teavm.jso.core.JSBoolean;
import org.teavm.jso.core.JSNumber;
import org.teavm.jso.core.JSString;

/**
 * TeaVM implementation of NativeAstObject.
 *
 * @author Bruno Salmon
 */
public final class TeaVmAstObject extends TeaVmAstNode implements NativeAstObject {

    public static TeaVmAstObject create(JSObject jso) {
        if (jso == null || isUndefined(jso))
            return null;
        return new TeaVmAstObject(jso);
    }

    TeaVmAstObject(JSObject jso) {
        super(jso);
    }

    @Override
    public NativeAstFactoryProvider getProvider() {
        return TeaVmAstFactoryProvider.INSTANCE;
    }

    @Override
    public JSObject getNativeElement(String key) {
        return getJSValue(nativeElement, key);
    }

    @Override
    public Double getDouble(String key) {
        return js2Double(getNativeElement(key));
    }


    @Override
    public String getString(String key) {
        return js2String(getNativeElement(key));
    }

    @Override
    public boolean has(String key) {
        return has(nativeElement, key);
    }

    @Override
    public TeaVmAstArray keys() {
        return TeaVmAstArray.create(getKeys(nativeElement));
    }


    @Override
    public void clear() {
        clear(nativeElement);
    }

    @Override
    public <T> T remove(String key) {
        deleteJSValue(nativeElement, key);
        return null;
    }

    @Override
    public void setNativeElement(String key, Object element) {
        setJSValue(nativeElement, key, (JSObject) element);
    }

    @Override
    public TeaVmAstObject set(String key, Boolean value) {
        setNativeElement(key, JSBoolean.valueOf(value));
        return this;
    }

    @Override
    public TeaVmAstObject set(String key, Double value) {
        setNativeElement(key, JSNumber.valueOf(value));
        return this;
    }

    @Override
    public TeaVmAstObject set(String key, String value) {
        setNativeElement(key, JSString.valueOf(value));
        return this;
    }

}