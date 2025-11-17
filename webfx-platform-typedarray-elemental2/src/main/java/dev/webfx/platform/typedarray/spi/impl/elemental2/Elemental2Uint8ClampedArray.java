package dev.webfx.platform.typedarray.spi.impl.elemental2;

import dev.webfx.platform.typedarray.Uint8ClampedArray;

/**
 * @author Bruno Salmon
 */
record Elemental2Uint8ClampedArray(elemental2.core.Uint8ClampedArray e2Uint8ClampedArray) implements Uint8ClampedArray {

    @Override
    public short get(int index) {
        return e2Uint8ClampedArray.getAt(index).shortValue();
    }

    @Override
    public void set(int index, short value) {
        e2Uint8ClampedArray.setAt(index, (double) value);
    }

    @Override
    public int getLength() {
        return e2Uint8ClampedArray.byteLength;
    }

    @Override
    public Object getNativeArray() {
        return e2Uint8ClampedArray;
    }

    @Override
    public Object getTransferableBuffer() {
        return e2Uint8ClampedArray.buffer;
    }
}