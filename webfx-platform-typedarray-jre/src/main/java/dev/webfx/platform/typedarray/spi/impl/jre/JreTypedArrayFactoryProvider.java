package dev.webfx.platform.typedarray.spi.impl.jre;

import dev.webfx.platform.typedarray.*;
import dev.webfx.platform.typedarray.spi.TypedArrayFactoryProvider;

/**
 * JRE implementation of the TypedArray factory that simply wraps Java primitive arrays and a byte[] ArrayBuffer.
 *
 * This is meant for JVM runtimes (desktop/server). It does not support SharedArrayBuffer.
 */
public final class JreTypedArrayFactoryProvider implements TypedArrayFactoryProvider {

    @Override
    public TypedArray wrapNativeArray(Object nativeArray) {
        if (nativeArray instanceof double[] d)
            return new JreFloat64Array(d);
        if (nativeArray instanceof float[] f)
            return new JreFloat32Array(f);
        if (nativeArray instanceof short[] s)
            return new JreUint16Array(s);
        if (nativeArray instanceof byte[] b)
            return new JreUint8Array(b);
        return null;
    }

    @Override
    public ArrayBuffer wrapTransferableBuffer(Object transferableBuffer) {
        if (transferableBuffer instanceof ArrayBuffer arrayBuffer)
            return arrayBuffer;
        return null;
    }

    @Override
    public Float64Array createFloat64Array(int length) {
        return new JreFloat64Array(new double[length]);
    }

    @Override
    public Float32Array createFloat32Array(int length) {
        return new JreFloat32Array(new float[length]);
    }

    @Override
    public Uint16Array createUint16Array(int length) {
        return new JreUint16Array(new short[length]);
    }

    @Override
    public Uint8Array createUint8Array(int length) {
        return new JreUint8Array(new byte[length]);
    }

    @Override
    public Uint8ClampedArray createUint8ClampedArray(int length) {
        return new JreUint8ClampedArray(new byte[length]);
    }

    @Override
    public Float64Array createFloat64Array(double... array) {
        double[] a = array != null ? array : new double[0];
        return new JreFloat64Array(a.clone());
    }

    @Override
    public Float32Array createFloat32Array(double... array) {
        if (array == null)
            return new JreFloat32Array(new float[0]);
        float[] f = new float[array.length];
        for (int i = 0; i < array.length; i++)
            f[i] = (float) array[i];
        return new JreFloat32Array(f);
    }

    @Override
    public Uint16Array createUint16Array(double... array) {
        if (array == null)
            return new JreUint16Array(new short[0]);
        short[] s = new short[array.length];
        for (int i = 0; i < array.length; i++)
            s[i] = (short) ((int) Math.round(array[i]) & 0xFFFF);
        return new JreUint16Array(s);
    }

    @Override
    public Uint8Array createUint8Array(double... array) {
        if (array == null)
            return new JreUint8Array(new byte[0]);
        byte[] b = new byte[array.length];
        for (int i = 0; i < array.length; i++)
            b[i] = (byte) ((int) Math.round(array[i]) & 0xFF);
        return new JreUint8Array(b);
    }

    @Override
    public ArrayBuffer createArrayBuffer(int length) {
        return new JreInitialBuffer(length);
    }

    @Override
    public Float64Array createFloat64Array(ArrayBuffer arrayBuffer) {
        if (arrayBuffer instanceof Float64Array float64Array)
            return float64Array;
        if (arrayBuffer instanceof JreInitialBuffer initialBuffer)
            return createFloat64Array(initialBuffer.length());
        return null;
    }

    @Override
    public Float32Array createFloat32Array(ArrayBuffer arrayBuffer) {
        if (arrayBuffer instanceof Float32Array float32Array)
            return float32Array;
        if (arrayBuffer instanceof JreInitialBuffer initialBuffer)
            return createFloat32Array(initialBuffer.length());
        return null;
    }

    @Override
    public Uint16Array createUint16Array(ArrayBuffer arrayBuffer) {
        if (arrayBuffer instanceof Uint16Array uint16Array)
            return uint16Array;
        if (arrayBuffer instanceof JreInitialBuffer initialBuffer)
            return createUint16Array(initialBuffer.length());
        return null;
    }

    @Override
    public Uint8Array createUint8Array(ArrayBuffer arrayBuffer) {
        if (arrayBuffer instanceof Uint8Array uint8Array)
            return uint8Array;
        if (arrayBuffer instanceof JreInitialBuffer initialBuffer)
            return createUint8Array(initialBuffer.length());
        return null;
    }

    @Override
    public SharedArrayBuffer createSharedArrayBuffer(int length) {
        // Not supported on pure JRE implementation
        return null;
    }

    @Override
    public Float64Array createFloat64Array(SharedArrayBuffer sharedArrayBuffer) {
        return null;
    }

    @Override
    public Float32Array createFloat32Array(SharedArrayBuffer sharedArrayBuffer) {
        return null;
    }

    @Override
    public Uint16Array createUint16Array(SharedArrayBuffer sharedArrayBuffer) {
        return null;
    }

    @Override
    public Uint8Array createUint8Array(SharedArrayBuffer sharedArrayBuffer) {
        return null;
    }
}