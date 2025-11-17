package dev.webfx.platform.typedarray;

/**
 * @author Bruno Salmon
 */
public interface Float64Array extends TypedArray {

    double get(int index);

    void set(int index, double value);


}
