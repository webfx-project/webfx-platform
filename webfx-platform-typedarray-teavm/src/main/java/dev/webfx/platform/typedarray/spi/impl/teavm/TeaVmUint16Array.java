package dev.webfx.platform.typedarray.spi.impl.teavm;

import dev.webfx.platform.typedarray.Uint16Array;

/**
 * @author Bruno Salmon
 */
record TeaVmUint16Array(org.teavm.jso.typedarrays.Uint16Array tvUint16Array) implements Uint16Array {

    @Override
    public int get(int index) {
        return tvUint16Array.get(index);
    }

    @Override
    public void set(int index, int value) {
        tvUint16Array.set(index, value);
    }

    @Override
    public int getLength() {
        return tvUint16Array.getLength();
    }

    @Override
    public Object getNativeArray() {
        return tvUint16Array;
    }

    @Override
    public Object getTransferableBuffer() {
        return tvUint16Array.getBuffer();
    }
}
