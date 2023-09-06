package dev.webfx.platform.ast.json;

import dev.webfx.platform.ast.*;

/**
 * @author Bruno Salmon
 */
public final class JsonAstFactory implements NativeAstFactory {

    @Override
    public AstObject createObject() {
        return Json.createObject();
    }

    @Override
    public AstArray createArray() {
        return Json.createArray();
    }

    @Override
    public boolean isNativeObject(ReadOnlyAstObject astObject) {
        return astObject instanceof ReadOnlyJsonObject;
    }

    @Override
    public boolean isNativeArray(ReadOnlyAstArray array) {
        return array instanceof ReadOnlyJsonArray;
    }

    @Override
    public Object unwrapNativeObject(ReadOnlyAstObject nativeObject) {
        return ((JsonObject) nativeObject).getNativeElement();
    }

    @Override
    public Object unwrapNativeArray(ReadOnlyAstArray nativeArray) {
        return ((JsonObject) nativeArray).getNativeElement();
    }
}