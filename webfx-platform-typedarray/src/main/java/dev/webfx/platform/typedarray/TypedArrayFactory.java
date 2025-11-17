package dev.webfx.platform.typedarray;

import dev.webfx.platform.typedarray.spi.TypedArrayFactoryProvider;
import dev.webfx.platform.service.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public final class TypedArrayFactory {

    private static TypedArrayFactoryProvider getProvider() {
        return SingleServiceProvider.getProvider(TypedArrayFactoryProvider.class, () -> ServiceLoader.load(TypedArrayFactoryProvider.class));
    }

    public static TypedArray wrapNativeArray(Object nativeArray) {
        return getProvider().wrapNativeArray(nativeArray);
    }

    public static ArrayBuffer wrapNativeBuffer(Object nativeArray) {
        return getProvider().wrapTransferableBuffer(nativeArray);
    }

    public static Float64Array createFloat64Array(int length) {
        return getProvider().createFloat64Array(length);
    }

    public static Float32Array createFloat32Array(int length) {
        return getProvider().createFloat32Array(length);
    }

    public static Uint16Array createUint16Array(int length) {
        return getProvider().createUint16Array(length);
    }

    public static Uint8Array createUint8Array(int length) {
        return getProvider().createUint8Array(length);
    }

    public static Uint8ClampedArray createUint8ClampedArray(int length) {
        return getProvider().createUint8ClampedArray(length);
    }


    public static Float64Array createFloat64Array(double... array) {
        return getProvider().createFloat64Array(array);
    }

    public static Float32Array createFloat32Array(double... array) {
        return getProvider().createFloat32Array(array);
    }

    public static Uint16Array createUint16Array(double... array) {
        return getProvider().createUint16Array(array);
    }

    public static Uint8Array createUint8Array(double... array) {
        return getProvider().createUint8Array(array);
    }

    public static boolean isSharedArrayBufferSupported() {
        return getProvider().isSharedArrayBufferSupported();
    }

    public static ArrayBuffer createArrayBuffer(int length) {
        return getProvider().createArrayBuffer(length);
    }

    public static Float64Array createFloat64Array(ArrayBuffer array) {
        return getProvider().createFloat64Array(array);
    }

    public static Float32Array createFloat32Array(ArrayBuffer array) {
        return getProvider().createFloat32Array(array);
    }

    public static Uint16Array createUint16Array(ArrayBuffer array) {
        return getProvider().createUint16Array(array);
    }

    public static Uint8Array createUint8Array(ArrayBuffer array) {
        return getProvider().createUint8Array(array);
    }

    public static SharedArrayBuffer createSharedArrayBuffer(int length) {
        return getProvider().createSharedArrayBuffer(length);
    }

    public static Float64Array createFloat64Array(SharedArrayBuffer array) {
        return getProvider().createFloat64Array(array);
    }

    public static Float32Array createFloat32Array(SharedArrayBuffer array) {
        return getProvider().createFloat32Array(array);
    }

    public static Uint16Array createUint16Array(SharedArrayBuffer array) {
        return getProvider().createUint16Array(array);
    }

    public static Uint8Array createUint8Array(SharedArrayBuffer array) {
        return getProvider().createUint8Array(array);
    }
}
