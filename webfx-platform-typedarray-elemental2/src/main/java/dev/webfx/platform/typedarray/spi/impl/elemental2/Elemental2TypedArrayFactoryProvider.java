package dev.webfx.platform.typedarray.spi.impl.elemental2;

import dev.webfx.platform.typedarray.*;
import dev.webfx.platform.typedarray.spi.TypedArrayFactoryProvider;

/**
 * @author Bruno Salmon
 */
public final class Elemental2TypedArrayFactoryProvider implements TypedArrayFactoryProvider {

    @Override
    public TypedArray wrapNativeArray(Object nativeArray) {
        if (nativeArray instanceof elemental2.core.Float64Array e2Float64Array)
            return new Elemental2Float64Array(e2Float64Array);
        if (nativeArray instanceof elemental2.core.Float32Array e2Float32Array)
            return new Elemental2Float32Array(e2Float32Array);
        if (nativeArray instanceof elemental2.core.Uint16Array e2Uint16Array)
            return new Elemental2Uint16Array(e2Uint16Array);
        if (nativeArray instanceof elemental2.core.Uint8Array e2Uint8Array)
            return new Elemental2Uint8Array(e2Uint8Array);
        if (nativeArray instanceof elemental2.core.Uint8ClampedArray e2Uint8ClampedArray)
            return new Elemental2Uint8ClampedArray(e2Uint8ClampedArray);
        return null;
    }

    @Override
    public ArrayBuffer wrapTransferableBuffer(Object transferableBuffer) {
        if (transferableBuffer instanceof elemental2.core.ArrayBuffer e2ArrayBuffer)
            return new Elemental2ArrayBuffer(e2ArrayBuffer);
        return null;
    }

    @Override
    public Float64Array createFloat64Array(int length) {
        return new Elemental2Float64Array(new elemental2.core.Float64Array(length));
    }

    @Override
    public Float32Array createFloat32Array(int length) {
        return new Elemental2Float32Array(new elemental2.core.Float32Array(length));
    }

    @Override
    public Uint8ClampedArray createUint8ClampedArray(int length) {
        return new Elemental2Uint8ClampedArray(new elemental2.core.Uint8ClampedArray(length));
    }

    @Override
    public Uint16Array createUint16Array(int length) {
        return new Elemental2Uint16Array(new elemental2.core.Uint16Array(length));
    }

    @Override
    public Uint8Array createUint8Array(int length) {
        return new Elemental2Uint8Array(new elemental2.core.Uint8Array(length));
    }

    @Override
    public Float64Array createFloat64Array(double... array) {
        return new Elemental2Float64Array(new elemental2.core.Float64Array(array));
    }

    @Override
    public Float32Array createFloat32Array(double... array) {
        return new Elemental2Float32Array(new elemental2.core.Float32Array(array));
    }

    @Override
    public Uint16Array createUint16Array(double... array) {
        return new Elemental2Uint16Array(new elemental2.core.Uint16Array(array));
    }

    @Override
    public Uint8Array createUint8Array(double... array) {
        return new Elemental2Uint8Array(new elemental2.core.Uint8Array(array));
    }

    @Override
    public ArrayBuffer createArrayBuffer(int length) {
        return new Elemental2ArrayBuffer(new elemental2.core.ArrayBuffer(length));
    }

    @Override
    public Float64Array createFloat64Array(ArrayBuffer sharedArrayBuffer) {
        return new Elemental2Float64Array(new elemental2.core.Float64Array(((Elemental2ArrayBuffer) sharedArrayBuffer).e2ArrayBuffer()));
    }

    @Override
    public Float32Array createFloat32Array(ArrayBuffer sharedArrayBuffer) {
        return new Elemental2Float32Array(new elemental2.core.Float32Array(((Elemental2ArrayBuffer) sharedArrayBuffer).e2ArrayBuffer()));
    }

    @Override
    public Uint16Array createUint16Array(ArrayBuffer sharedArrayBuffer) {
        return new Elemental2Uint16Array(new elemental2.core.Uint16Array(((Elemental2ArrayBuffer) sharedArrayBuffer).e2ArrayBuffer()));
    }

    @Override
    public Uint8Array createUint8Array(ArrayBuffer sharedArrayBuffer) {
        return new Elemental2Uint8Array(new elemental2.core.Uint8Array(((Elemental2ArrayBuffer) sharedArrayBuffer).e2ArrayBuffer()));
    }

    @Override
    public SharedArrayBuffer createSharedArrayBuffer(int length) {
        return new Elemental2SharedArrayBuffer(new elemental2.core.SharedArrayBuffer(length));
    }

    @Override
    public Float64Array createFloat64Array(SharedArrayBuffer sharedArrayBuffer) {
        return new Elemental2Float64Array(new elemental2.core.Float64Array(((Elemental2SharedArrayBuffer) sharedArrayBuffer).e2SharedArrayBuffer()));
    }

    @Override
    public Float32Array createFloat32Array(SharedArrayBuffer sharedArrayBuffer) {
        return new Elemental2Float32Array(new elemental2.core.Float32Array(((Elemental2SharedArrayBuffer) sharedArrayBuffer).e2SharedArrayBuffer()));
    }

    @Override
    public Uint16Array createUint16Array(SharedArrayBuffer sharedArrayBuffer) {
        return new Elemental2Uint16Array(new elemental2.core.Uint16Array(((Elemental2SharedArrayBuffer) sharedArrayBuffer).e2SharedArrayBuffer()));
    }

    @Override
    public Uint8Array createUint8Array(SharedArrayBuffer sharedArrayBuffer) {
        return new Elemental2Uint8Array(new elemental2.core.Uint8Array(((Elemental2SharedArrayBuffer) sharedArrayBuffer).e2SharedArrayBuffer()));
    }
}
