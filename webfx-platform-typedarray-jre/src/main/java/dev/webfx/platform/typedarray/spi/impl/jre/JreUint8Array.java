package dev.webfx.platform.typedarray.spi.impl.jre;

import dev.webfx.platform.typedarray.ArrayBuffer;
import dev.webfx.platform.typedarray.Uint8Array;

/**
 * Uint8Array wrapper backed by a Java byte[] array (unsigned semantics on get/set).
 */
record JreUint8Array(byte[] array) implements Uint8Array, ArrayBuffer {

    @Override
    public short get(int index) {
        return (short) (array[index] & 0xFF);
    }

    @Override
    public void set(int index, short value) {
        int v = value & 0xFF;
        array[index] = (byte) v;
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