package dev.webfx.platform.typedarray.spi.impl.teavm;

import dev.webfx.platform.typedarray.TypedArray;
import org.teavm.jso.typedarrays.ArrayBuffer;
import org.teavm.jso.typedarrays.ArrayBufferView;

/**
 * @author Bruno Salmon
 */
final class TeaVmTypedArray implements TypedArray {

    public final ArrayBuffer jsArrayBuffer;
    public final ArrayBufferView jsArrayBufferView;

    public TeaVmTypedArray(ArrayBuffer jsArrayBuffer) {
        this.jsArrayBuffer = jsArrayBuffer;
        this.jsArrayBufferView = null;
    }

    public TeaVmTypedArray(ArrayBufferView jsArrayBufferView) {
        this.jsArrayBuffer = null;
        this.jsArrayBufferView = jsArrayBufferView;
    }
}