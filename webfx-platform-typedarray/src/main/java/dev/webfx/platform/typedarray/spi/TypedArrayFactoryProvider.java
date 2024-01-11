package dev.webfx.platform.typedarray.spi;

import dev.webfx.platform.typedarray.TypedArray;

/**
 * @author Bruno Salmon
 */
public interface TypedArrayFactoryProvider {

    TypedArray createFloat32Array(double... array);

    TypedArray createUint16Array(double... array);

    TypedArray Uint8Array(double... array);

}
