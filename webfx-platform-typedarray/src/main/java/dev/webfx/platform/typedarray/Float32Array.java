package dev.webfx.platform.typedarray;

/**
 * @author Bruno Salmon
 */
public interface Float32Array extends TypedArray {

    float get(int index);

    void set(int index, float value);

}
