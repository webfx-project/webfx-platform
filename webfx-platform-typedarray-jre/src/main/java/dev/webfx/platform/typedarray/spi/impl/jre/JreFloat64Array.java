package dev.webfx.platform.typedarray.spi.impl.jre;

import dev.webfx.platform.typedarray.ArrayBuffer;
import dev.webfx.platform.typedarray.Float64Array;

/**
 * Float64Array wrapper backed by a Java double[] array.
 */
record JreFloat64Array(double[] array) implements Float64Array, ArrayBuffer {

    @Override
    public double get(int index) {
        return array[index];
    }

    @Override
    public void set(int index, double value) {
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