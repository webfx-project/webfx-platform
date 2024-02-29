package dev.webfx.platform.ast.spi.factory.impl.gwt;

import com.google.gwt.core.client.JavaScriptObject;
import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstArray;
import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstFactoryProvider;

/**
 * @author Bruno Salmon
 */
public final class GwtAstArray extends GwtAstNode implements NativeAstArray {

    // GWT: Constructors must be 'protected' in subclasses of JavaScriptObject
    protected GwtAstArray() {} // instances are actually always obtained from a javascript array cast

    static GwtAstArray create() {
        return createArray().cast();
    }

    @Override
    public NativeAstFactoryProvider getProvider() {
        return GwtAstFactoryProvider.INSTANCE;
    }

    @Override
    public GwtAstObject getObject(int index) {
        return getNativeElement(index).cast();
    }

    @Override
    public GwtAstArray getArray(int index) {
        return getNativeElement(index).cast();
    }

    @Override
    public native <V> V remove(int index) /*-{
        return this.splice(index, 1)[0];
     }-*/;

    @Override
    public native void clear() /*-{
        this.length = 0;
    }-*/;

    @Override
    public native int size() /*-{
        return this.length;
    }-*/;

    @Override
    public native int indexOfNativeElement(Object element) /*-{
        return this.indexOf(element);
    }-*/;

    @Override
    public native JavaScriptObject getNativeElement(int index) /*-{
        return this[index];
      }-*/;

    @Override
    public native void pushNativeElement(Object element) /*-{
        this[this.length] = element;
    }-*/;

    @Override
    public native void setNativeElement(int index, Object element) /*-{
        this[index] = element;
    }-*/;

    @Override
    public native Boolean getBoolean(int index) /*-{
        return this[index];
    }-*/;

    @Override
    public native Double getDouble(int index) /*-{
        return this[index];
    }-*/;

    @Override
    public native String getString(int index) /*-{
        return this[index];
    }-*/;

    @Override
    public native GwtAstArray push(boolean value) /*-{
        this[this.length] = value;
        return this;
      }-*/;

    @Override
    public native GwtAstArray push(double value) /*-{
        this[this.length] = value;
        return this;
      }-*/;

    @Override
    public native GwtAstArray push(String value) /*-{
        this[this.length] = value;
        return this;
     }-*/;
}
