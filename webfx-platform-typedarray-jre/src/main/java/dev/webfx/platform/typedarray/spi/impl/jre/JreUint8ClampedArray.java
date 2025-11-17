package dev.webfx.platform.typedarray.spi.impl.jre;

import dev.webfx.platform.typedarray.ArrayBuffer;
import dev.webfx.platform.typedarray.Uint8ClampedArray;

/**
 * Uint8ClampedArray wrapper backed by a Java byte[] array with clamping on write.
 */
record JreUint8ClampedArray(byte[] array) implements Uint8ClampedArray, ArrayBuffer {

    @Override
    public short get(int index) {
        return (short) (array[index] & 0xFF);
    }

    @Override
    public void set(int index, short value) {
        int v = value;
        if (v < 0) v = 0;
        if (v > 255) v = 255;
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