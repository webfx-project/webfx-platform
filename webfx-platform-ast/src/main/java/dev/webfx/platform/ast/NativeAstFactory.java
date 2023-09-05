package dev.webfx.platform.ast;

/**
 * @author Bruno Salmon
 */
public interface NativeAstFactory extends AstFactory {

    boolean isNativeObject(ReadOnlyAstObject astObject);

    boolean isNativeArray(ReadOnlyAstArray array);

    Object unwrapNativeObject(ReadOnlyAstObject nativeObject);

    Object unwrapNativeArray(ReadOnlyAstArray nativeArray);

}
