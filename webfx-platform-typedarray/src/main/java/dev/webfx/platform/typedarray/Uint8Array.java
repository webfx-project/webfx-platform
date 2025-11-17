package dev.webfx.platform.typedarray;

/**
 * @author Bruno Salmon
 */
public interface Uint8Array extends TypedArray {

    short get(int index);

    void set(int index, short value);

}
