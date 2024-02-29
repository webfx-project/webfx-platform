package dev.webfx.platform.ast.spi.factory.impl.gwt;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstFactoryProvider;
import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstObject;

/**
 * @author Bruno Salmon
 */
public final class GwtAstObject extends GwtAstNode implements NativeAstObject {

    // GWT: Constructors must be 'protected' in subclasses of JavaScriptObject
    protected GwtAstObject() {} // instances are actually always obtained from a javascript object cast

    public static GwtAstObject create() {
        return createObject().cast();
    }

    @Override
    public NativeAstFactoryProvider getProvider() {
        return GwtAstFactoryProvider.INSTANCE;
    }

    @Override
    public native JavaScriptObject getNativeElement(String key) /*-{
        return this[key];
    }-*/;

    @Override
    public native void setNativeElement(String key, Object element) /*-{
        this[key] = element;
    }-*/;

    @Override
    public native boolean has(String key) /*-{
        return key in this;
    }-*/;

    @Override
    public native void clear() /*-{
        for (var key in this)
            if (Object.prototype.hasOwnProperty.call(this, key))
                delete this[key];
        return this;
    }-*/;

    @Override
    public native <T> T remove(String key) /*-{
        var old = this[key];
        delete this[key];
        return old;
    }-*/;

    @Override
    public ReadOnlyAstArray keys() {
        return getProvider().nativeToAstArray(nativeKeys());
    }

    private native JsArrayString nativeKeys() /*-{
        var keys = [];
        for(var key in this)
          if (Object.prototype.hasOwnProperty.call(this, key) && key != '$H')
            keys.push(key);
        return keys;
    }-*/;

}
