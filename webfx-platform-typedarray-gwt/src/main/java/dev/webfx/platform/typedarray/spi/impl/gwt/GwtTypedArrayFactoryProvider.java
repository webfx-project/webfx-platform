package dev.webfx.platform.typedarray.spi.impl.gwt;

import dev.webfx.platform.typedarray.TypedArray;
import dev.webfx.platform.typedarray.spi.TypedArrayFactoryProvider;
import elemental2.core.Float32Array;
import elemental2.core.Uint16Array;
import elemental2.core.Uint8Array;

/**
 * @author Bruno Salmon
 */
public class GwtTypedArrayFactoryProvider implements TypedArrayFactoryProvider {

    @Override
    public TypedArray createFloat32Array(double... array) {
        return new GwtTypedArray(new Float32Array(array));
    }

    @Override
    public TypedArray createUint16Array(double... array) {
        return new GwtTypedArray(new Uint16Array(array));
    }

    @Override
    public TypedArray Uint8Array(double... array) {
        return new GwtTypedArray(new Uint8Array(array));
    }
}
