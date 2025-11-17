package dev.webfx.platform.typedarray.spi.impl.elemental2;

import dev.webfx.platform.typedarray.Float32Array;

/**
 * @author Bruno Salmon
 */
record Elemental2Float32Array(elemental2.core.Float32Array e2Float32Array) implements Float32Array {

    @Override
    public float get(int index) {
        return e2Float32Array.getAt(index).floatValue();
    }

    @Override
    public void set(int index, float value) {
        e2Float32Array.setAt(index, (double) value);
    }

    @Override
    public int getLength() {
        return e2Float32Array.byteLength;
    }

    @Override
    public Object getNativeArray() {
        return e2Float32Array;
    }

    @Override
    public Object getTransferableBuffer() {
        return e2Float32Array.buffer;
    }
}
