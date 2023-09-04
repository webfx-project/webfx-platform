package dev.webfx.platform.json.tree;

import dev.webfx.platform.json.Json;
import dev.webfx.platform.json.JsonObject;
import dev.webfx.platform.json.ReadOnlyJsonArray;
import dev.webfx.platform.json.ReadOnlyJsonObject;
import dev.webfx.platform.util.keyobject.*;

/**
 * @author Bruno Salmon
 */
public final class JsonAstFactory implements NativeAstFactory {

    @Override
    public KeyObject createObject() {
        return Json.createObject();
    }

    @Override
    public IndexedArray createArray() {
        return Json.createArray();
    }

    @Override
    public boolean isNativeObject(ReadOnlyKeyObject keyObject) {
        return keyObject instanceof ReadOnlyJsonObject;
    }

    @Override
    public boolean isNativeArray(ReadOnlyIndexedArray array) {
        return array instanceof ReadOnlyJsonArray;
    }

    @Override
    public Object unwrapNativeObject(ReadOnlyKeyObject nativeObject) {
        return ((JsonObject) nativeObject).getNativeElement();
    }

    @Override
    public Object unwrapNativeArray(ReadOnlyIndexedArray nativeArray) {
        return ((JsonObject) nativeArray).getNativeElement();
    }
}
