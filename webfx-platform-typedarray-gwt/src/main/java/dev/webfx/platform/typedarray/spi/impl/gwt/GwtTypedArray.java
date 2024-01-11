package dev.webfx.platform.typedarray.spi.impl.gwt;

import dev.webfx.platform.typedarray.TypedArray;
import elemental2.core.ArrayBufferView;

/**
 * @author Bruno Salmon
 */
public class GwtTypedArray implements TypedArray {

    public final elemental2.core.ArrayBuffer jsArrayBuffer;
    public final ArrayBufferView jsArrayBufferView;

    public GwtTypedArray(elemental2.core.ArrayBuffer jsArrayBuffer) {
        this.jsArrayBuffer = jsArrayBuffer;
        this.jsArrayBufferView = null;
    }

    public GwtTypedArray(ArrayBufferView jsArrayBufferView) {
        this.jsArrayBuffer = null;
        this.jsArrayBufferView = jsArrayBufferView;
    }
}
