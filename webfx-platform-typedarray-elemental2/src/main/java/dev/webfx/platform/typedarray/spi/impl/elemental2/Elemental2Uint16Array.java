package dev.webfx.platform.typedarray.spi.impl.elemental2;

import dev.webfx.platform.typedarray.Uint16Array;

/**
 * @author Bruno Salmon
 */
record Elemental2Uint16Array(elemental2.core.Uint16Array e2Uint16Array) implements Uint16Array {

    @Override
    public int get(int index) {
        return e2Uint16Array.getAt(index).intValue();
    }

    @Override
    public void set(int index, int value) {
        e2Uint16Array.setAt(index, (double) value);
    }

    @Override
    public int getLength() {
        return e2Uint16Array.byteLength;
    }

    @Override
    public Object getNativeArray() {
        return e2Uint16Array;
    }

    @Override
    public Object getTransferableBuffer() {
        return e2Uint16Array.buffer;
    }
}
