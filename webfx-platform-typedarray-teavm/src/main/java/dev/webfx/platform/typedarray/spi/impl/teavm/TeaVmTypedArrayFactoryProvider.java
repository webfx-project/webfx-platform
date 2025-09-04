package dev.webfx.platform.typedarray.spi.impl.teavm;

import dev.webfx.platform.typedarray.TypedArray;
import dev.webfx.platform.typedarray.spi.TypedArrayFactoryProvider;
import org.teavm.jso.typedarrays.Float32Array;
import org.teavm.jso.typedarrays.Uint16Array;
import org.teavm.jso.typedarrays.Uint8Array;

/**
 * @author Bruno Salmon
 */
public class TeaVmTypedArrayFactoryProvider implements TypedArrayFactoryProvider {

    @Override
    public TypedArray createFloat32Array(double... array) {
        Float32Array float32Array = new Float32Array(array.length);
        for (int i = 0; i < array.length; i++)
            float32Array.set(i, (float) array[i]);
        return new TeaVmTypedArray(float32Array);
    }

    @Override
    public TypedArray createUint16Array(double... array) {
        Uint16Array uint16Array = new Uint16Array(array.length);
        for (int i = 0; i < array.length; i++)
            uint16Array.set(i, (int) array[i]);
        return new TeaVmTypedArray(uint16Array);
    }

    @Override
    public TypedArray Uint8Array(double... array) {
        Uint8Array uint8Array = new Uint8Array(array.length);
        for (int i = 0; i < array.length; i++)
            uint8Array.set(i, (short) array[i]);
        return new TeaVmTypedArray(uint8Array);
    }
}