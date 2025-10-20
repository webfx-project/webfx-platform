package dev.webfx.platform.typedarray.spi.impl.elemental2;

import dev.webfx.platform.typedarray.TypedArray;
import dev.webfx.platform.typedarray.spi.TypedArrayFactoryProvider;
import elemental2.core.Float32Array;
import elemental2.core.Uint16Array;
import elemental2.core.Uint8Array;

/**
 * @author Bruno Salmon
 */
public class Elemental2TypedArrayFactoryProvider implements TypedArrayFactoryProvider {

    @Override
    public TypedArray createFloat32Array(double... array) {
        return new Elemental2TypedArray(new Float32Array(array));
    }

    @Override
    public TypedArray createUint16Array(double... array) {
        return new Elemental2TypedArray(new Uint16Array(array));
    }

    @Override
    public TypedArray Uint8Array(double... array) {
        return new Elemental2TypedArray(new Uint8Array(array));
    }
}
