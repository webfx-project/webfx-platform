package dev.webfx.platform.typedarray.spi.impl.teavm;

import dev.webfx.platform.typedarray.Uint8ClampedArray;

/**
 * @author Bruno Salmon
 */
record TeaVmUint8ClampedArray(org.teavm.jso.typedarrays.Uint8ClampedArray tvUint8ClampedArray) implements Uint8ClampedArray {

    @Override
    public short get(int index) {
        return tvUint8ClampedArray.get(index);
    }

    @Override
    public void set(int index, short value) {
        tvUint8ClampedArray.set(index, value);
    }

    @Override
    public int getLength() {
        return tvUint8ClampedArray.getLength();
    }

    @Override
    public Object getNativeArray() {
        return tvUint8ClampedArray;
    }

    @Override
    public Object getTransferableBuffer() {
        return tvUint8ClampedArray.getBuffer();
    }
}