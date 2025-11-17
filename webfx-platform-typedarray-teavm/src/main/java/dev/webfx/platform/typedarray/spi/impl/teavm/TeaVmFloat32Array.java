package dev.webfx.platform.typedarray.spi.impl.teavm;

import dev.webfx.platform.typedarray.Float32Array;

/**
 * @author Bruno Salmon
 */
record TeaVmFloat32Array(org.teavm.jso.typedarrays.Float32Array tvFloat32Array) implements Float32Array {

    @Override
    public float get(int index) {
        return tvFloat32Array.get(index);
    }

    @Override
    public void set(int index, float value) {
        tvFloat32Array.set(index, value);
    }

    @Override
    public int getLength() {
        return tvFloat32Array.getLength();
    }

    @Override
    public Object getNativeArray() {
        return tvFloat32Array;
    }

    @Override
    public Object getTransferableBuffer() {
        return tvFloat32Array.getBuffer();
    }
}