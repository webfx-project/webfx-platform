package dev.webfx.platform.typedarray.spi.impl.teavm;

import dev.webfx.platform.typedarray.Uint8Array;

/**
 * @author Bruno Salmon
 */
record TeaVmUint8Array(org.teavm.jso.typedarrays.Uint8Array tvUint8Array) implements Uint8Array {

    @Override
    public short get(int index) {
        return tvUint8Array.get(index);
    }

    @Override
    public void set(int index, short value) {
        tvUint8Array.set(index, value);
    }

    @Override
    public int getLength() {
        return tvUint8Array.getLength();
    }

    @Override
    public Object getNativeArray() {
        return tvUint8Array;
    }

    @Override
    public Object getTransferableBuffer() {
        return tvUint8Array.getBuffer();
    }
}