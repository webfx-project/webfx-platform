package dev.webfx.platform.typedarray.spi.impl.elemental2;

import dev.webfx.platform.typedarray.TypedArray;
import elemental2.core.ArrayBufferView;

/**
 * @author Bruno Salmon
 */
public final class Elemental2TypedArray implements TypedArray {

    public final elemental2.core.ArrayBuffer jsArrayBuffer;
    public final ArrayBufferView jsArrayBufferView;

    Elemental2TypedArray(elemental2.core.ArrayBuffer jsArrayBuffer) {
        this.jsArrayBuffer = jsArrayBuffer;
        this.jsArrayBufferView = null;
    }

    Elemental2TypedArray(ArrayBufferView jsArrayBufferView) {
        this.jsArrayBuffer = null;
        this.jsArrayBufferView = jsArrayBufferView;
    }
}
