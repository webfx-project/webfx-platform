package dev.webfx.platform.typedarray.spi.impl.elemental2;

import dev.webfx.platform.typedarray.Float64Array;

/**
 * @author Bruno Salmon
 */
record Elemental2Float64Array(elemental2.core.Float64Array e2Float64Array) implements Float64Array {

    @Override
    public double get(int index) {
        return e2Float64Array.getAt(index);
    }

    @Override
    public void set(int index, double value) {
        e2Float64Array.setAt(index, value);
    }

    @Override
    public int getLength() {
        return e2Float64Array.byteLength;
    }

    @Override
    public Object getNativeArray() {
        return e2Float64Array;
    }

    @Override
    public Object getTransferableBuffer() {
        return e2Float64Array.buffer;
    }
}