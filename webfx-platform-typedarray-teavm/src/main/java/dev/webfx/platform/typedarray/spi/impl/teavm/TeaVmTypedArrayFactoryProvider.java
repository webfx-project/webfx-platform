package dev.webfx.platform.typedarray.spi.impl.teavm;

import dev.webfx.platform.typedarray.*;
import dev.webfx.platform.typedarray.spi.TypedArrayFactoryProvider;
import org.teavm.jso.JSBody;

/**
 * @author Bruno Salmon
 */
public final class TeaVmTypedArrayFactoryProvider implements TypedArrayFactoryProvider {

    @Override
    public TypedArray wrapNativeArray(Object nativeArray) {
        if (nativeArray instanceof org.teavm.jso.typedarrays.Float64Array tvFloat64Array)
            return new TeaVmFloat64Array(tvFloat64Array);
        if (nativeArray instanceof org.teavm.jso.typedarrays.Float32Array tvFloat32Array)
            return new TeaVmFloat32Array(tvFloat32Array);
        if (nativeArray instanceof org.teavm.jso.typedarrays.Uint16Array tvUint16Array)
            return new TeaVmUint16Array(tvUint16Array);
        if (nativeArray instanceof org.teavm.jso.typedarrays.Uint8Array tvUint8Array)
            return new TeaVmUint8Array(tvUint8Array);
        if (nativeArray instanceof org.teavm.jso.typedarrays.Uint8ClampedArray tvUint8ClampedArray)
            return new TeaVmUint8ClampedArray(tvUint8ClampedArray);
        return null;
    }

    @Override
    public ArrayBuffer wrapTransferableBuffer(Object transferableBuffer) {
        if (transferableBuffer instanceof org.teavm.jso.typedarrays.ArrayBuffer tvArrayBuffer)
            return new TeaVmArrayBuffer(tvArrayBuffer);
        return null;
    }

    @Override
    public Float64Array createFloat64Array(int length) {
        return new TeaVmFloat64Array(new org.teavm.jso.typedarrays.Float64Array(length));
    }

    @Override
    public Float32Array createFloat32Array(int length) {
        return new TeaVmFloat32Array(new org.teavm.jso.typedarrays.Float32Array(length));
    }

    @Override
    public Uint16Array createUint16Array(int length) {
        return new TeaVmUint16Array(new org.teavm.jso.typedarrays.Uint16Array(length));
    }

    @Override
    public Uint8Array createUint8Array(int length) {
        return new TeaVmUint8Array(new org.teavm.jso.typedarrays.Uint8Array(length));
    }

    @Override
    public Uint8ClampedArray createUint8ClampedArray(int length) {
        return new TeaVmUint8ClampedArray(new org.teavm.jso.typedarrays.Uint8ClampedArray(length));
    }

    @Override
    public Float64Array createFloat64Array(double... array) {
        org.teavm.jso.typedarrays.Float64Array float64Array = new org.teavm.jso.typedarrays.Float64Array(array.length);
        for (int i = 0; i < array.length; i++)
            float64Array.set(i, array[i]);
        return new TeaVmFloat64Array(float64Array);
    }

    @Override
    public Float32Array createFloat32Array(double... array) {
        org.teavm.jso.typedarrays.Float32Array float32Array = new org.teavm.jso.typedarrays.Float32Array(array.length);
        for (int i = 0; i < array.length; i++)
            float32Array.set(i, (float) array[i]);
        return new TeaVmFloat32Array(float32Array);
    }

    @Override
    public Uint16Array createUint16Array(double... array) {
        org.teavm.jso.typedarrays.Uint16Array uint16Array = new org.teavm.jso.typedarrays.Uint16Array(array.length);
        for (int i = 0; i < array.length; i++)
            uint16Array.set(i, (int) array[i]);
        return new TeaVmUint16Array(uint16Array);
    }

    @Override
    public Uint8Array createUint8Array(double... array) {
        org.teavm.jso.typedarrays.Uint8Array uint8Array = new org.teavm.jso.typedarrays.Uint8Array(array.length);
        for (int i = 0; i < array.length; i++)
            uint8Array.set(i, (short) array[i]);
        return new TeaVmUint8Array(uint8Array);
    }

    @Override
    public ArrayBuffer createArrayBuffer(int length) {
        return new TeaVmArrayBuffer(new org.teavm.jso.typedarrays.ArrayBuffer(length));
    }

    @Override
    public Float64Array createFloat64Array(ArrayBuffer sharedArrayBuffer) {
        return new TeaVmFloat64Array(new org.teavm.jso.typedarrays.Float64Array(((TeaVmArrayBuffer) sharedArrayBuffer).tvArrayBuffer()));
    }

    @Override
    public Float32Array createFloat32Array(ArrayBuffer sharedArrayBuffer) {
        return new TeaVmFloat32Array(new org.teavm.jso.typedarrays.Float32Array(((TeaVmArrayBuffer) sharedArrayBuffer).tvArrayBuffer()));
    }

    @Override
    public Uint16Array createUint16Array(ArrayBuffer sharedArrayBuffer) {
        return new TeaVmUint16Array(new org.teavm.jso.typedarrays.Uint16Array(((TeaVmArrayBuffer) sharedArrayBuffer).tvArrayBuffer()));
    }

    @Override
    public Uint8Array createUint8Array(ArrayBuffer sharedArrayBuffer) {
        return new TeaVmUint8Array(new org.teavm.jso.typedarrays.Uint8Array(((TeaVmArrayBuffer) sharedArrayBuffer).tvArrayBuffer()));
    }

    @Override
    public SharedArrayBuffer createSharedArrayBuffer(int length) {
        return new TeaVmSharedArrayBuffer(newSharedArrayBuffer(length));
    }

    @JSBody(params = "length", script = "return new SharedArrayBuffer(length);")
    public static native org.teavm.jso.typedarrays.SharedArrayBuffer newSharedArrayBuffer(int length);

    @Override
    public Float64Array createFloat64Array(SharedArrayBuffer sharedArrayBuffer) {
        return new TeaVmFloat64Array(new org.teavm.jso.typedarrays.Float64Array(((TeaVmSharedArrayBuffer) sharedArrayBuffer).tvSharedArrayBuffer()));
    }

    @Override
    public Float32Array createFloat32Array(SharedArrayBuffer sharedArrayBuffer) {
        return new TeaVmFloat32Array(new org.teavm.jso.typedarrays.Float32Array(((TeaVmSharedArrayBuffer) sharedArrayBuffer).tvSharedArrayBuffer()));
    }

    @Override
    public Uint16Array createUint16Array(SharedArrayBuffer sharedArrayBuffer) {
        return new TeaVmUint16Array(new org.teavm.jso.typedarrays.Uint16Array(((TeaVmSharedArrayBuffer) sharedArrayBuffer).tvSharedArrayBuffer()));
    }

    @Override
    public Uint8Array createUint8Array(SharedArrayBuffer sharedArrayBuffer) {
        return new TeaVmUint8Array(new org.teavm.jso.typedarrays.Uint8Array(((TeaVmSharedArrayBuffer) sharedArrayBuffer).tvSharedArrayBuffer()));
    }
}