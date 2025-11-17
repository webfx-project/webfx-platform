package dev.webfx.platform.typedarray.spi.impl.elemental2;

import dev.webfx.platform.typedarray.Uint8Array;

/**
 * @author Bruno Salmon
 */
record Elemental2Uint8Array(elemental2.core.Uint8Array e2Uint8Array) implements Uint8Array {

    @Override
    public short get(int index) {
        return e2Uint8Array.getAt(index).shortValue();
    }

    @Override
    public void set(int index, short value) {
        e2Uint8Array.setAt(index, (double) value);
    }

    @Override
    public int getLength() {
        return e2Uint8Array.byteLength;
    }

    @Override
    public Object getNativeArray() {
        return e2Uint8Array;
    }

    @Override
    public Object getTransferableBuffer() {
        return e2Uint8Array.buffer;
    }
}