package dev.webfx.platform.util.keyobject;

/**
 * @author Bruno Salmon
 */
public interface NativeAstFactory extends AstFactory {

    boolean isNativeObject(ReadOnlyKeyObject keyObject);

    boolean isNativeArray(ReadOnlyIndexedArray array);

    Object unwrapNativeObject(ReadOnlyKeyObject nativeObject);

    Object unwrapNativeArray(ReadOnlyIndexedArray nativeArray);

}
