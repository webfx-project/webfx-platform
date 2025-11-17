package dev.webfx.platform.typedarray.spi.impl.teavm;

import dev.webfx.platform.typedarray.Float64Array;

/**
 * @author Bruno Salmon
 */
record TeaVmFloat64Array(org.teavm.jso.typedarrays.Float64Array tvFloat64Array) implements Float64Array {

    @Override
    public double get(int index) {
        return tvFloat64Array.get(index);
    }

    @Override
    public void set(int index, double value) {
        tvFloat64Array.set(index, value);
    }

    @Override
    public int getLength() {
        return tvFloat64Array.getLength();
    }

    @Override
    public Object getNativeArray() {
        return tvFloat64Array;
    }

    @Override
    public Object getTransferableBuffer() {
        return tvFloat64Array.getBuffer();
    }
}
