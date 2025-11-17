package dev.webfx.platform.typedarray;

/**
 * @author Bruno Salmon
 */
public interface TypedArray {

    int getLength();

    Object getNativeArray();

    Object getTransferableBuffer();

}
