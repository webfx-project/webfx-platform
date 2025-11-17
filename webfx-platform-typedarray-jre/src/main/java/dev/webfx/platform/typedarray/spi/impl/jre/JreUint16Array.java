package dev.webfx.platform.typedarray.spi.impl.jre;

import dev.webfx.platform.typedarray.ArrayBuffer;
import dev.webfx.platform.typedarray.Uint16Array;

/**
 * Uint16Array wrapper backed by a Java short[] array (unsigned semantics on get/set).
 */
record JreUint16Array(short[] array) implements Uint16Array, ArrayBuffer {

    @Override
    public int get(int index) {
        return array[index] & 0xFFFF;
    }

    @Override
    public void set(int index, int value) {
        int v = value;
        if (v < 0) v = 0;
        if (v > 0xFFFF) v = 0xFFFF;
        array[index] = (short) v;
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