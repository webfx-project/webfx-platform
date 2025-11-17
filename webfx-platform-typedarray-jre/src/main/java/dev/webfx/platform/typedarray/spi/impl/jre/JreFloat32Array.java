package dev.webfx.platform.typedarray.spi.impl.jre;

import dev.webfx.platform.typedarray.ArrayBuffer;
import dev.webfx.platform.typedarray.Float32Array;

/**
 * Float32Array wrapper backed by a Java float[] array.
 */
record JreFloat32Array(float[] array) implements Float32Array, ArrayBuffer {

    @Override
    public float get(int index) {
        return array[index];
    }

    @Override
    public void set(int index, float value) {
        array[index] = value;
    }

    @Override
    public int getLength() {
        return array.length;
    }

    @Override
    public Object getNativeArray() {
        return array;
    }

    @Override
    public Object getTransferableBuffer() {
        return this;
    }
}