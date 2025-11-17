package dev.webfx.platform.typedarray.spi;

import dev.webfx.platform.typedarray.*;

/**
 * @author Bruno Salmon
 */
public interface TypedArrayFactoryProvider {

    TypedArray wrapNativeArray(Object nativeArray);

    ArrayBuffer wrapTransferableBuffer(Object transferableBuffer);

    Float64Array createFloat64Array(int length);

    Float32Array createFloat32Array(int length);

    Uint16Array createUint16Array(int length);

    Uint8Array createUint8Array(int length);

    Uint8ClampedArray createUint8ClampedArray(int length);

    Float64Array createFloat64Array(double... array);

    Float32Array createFloat32Array(double... array);

    Uint16Array createUint16Array(double... array);

    Uint8Array createUint8Array(double... array);

    ArrayBuffer createArrayBuffer(int length);

    Float64Array createFloat64Array(ArrayBuffer sharedArrayBuffer);

    Float32Array createFloat32Array(ArrayBuffer sharedArrayBuffer);

    Uint16Array createUint16Array(ArrayBuffer sharedArrayBuffer);

    Uint8Array createUint8Array(ArrayBuffer sharedArrayBuffer);

    default boolean isSharedArrayBufferSupported() {
        try {
            return createSharedArrayBuffer(1) != null;
        } catch (Exception e) {
            return false;
        }
    }

    SharedArrayBuffer createSharedArrayBuffer(int length);

    Float64Array createFloat64Array(SharedArrayBuffer sharedArrayBuffer);

    Float32Array createFloat32Array(SharedArrayBuffer sharedArrayBuffer);

    Uint16Array createUint16Array(SharedArrayBuffer sharedArrayBuffer);

    Uint8Array createUint8Array(SharedArrayBuffer sharedArrayBuffer);

}
