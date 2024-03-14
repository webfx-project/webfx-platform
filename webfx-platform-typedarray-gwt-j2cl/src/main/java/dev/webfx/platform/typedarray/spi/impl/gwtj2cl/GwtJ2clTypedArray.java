package dev.webfx.platform.typedarray.spi.impl.gwtj2cl;

import dev.webfx.platform.typedarray.TypedArray;
import elemental2.core.ArrayBufferView;

/**
 * @author Bruno Salmon
 */
public class GwtJ2clTypedArray implements TypedArray {

    public final elemental2.core.ArrayBuffer jsArrayBuffer;
    public final ArrayBufferView jsArrayBufferView;

    public GwtJ2clTypedArray(elemental2.core.ArrayBuffer jsArrayBuffer) {
        this.jsArrayBuffer = jsArrayBuffer;
        this.jsArrayBufferView = null;
    }

    public GwtJ2clTypedArray(ArrayBufferView jsArrayBufferView) {
        this.jsArrayBuffer = null;
        this.jsArrayBufferView = jsArrayBufferView;
    }
}
