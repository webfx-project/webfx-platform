package dev.webfx.platform.json.spi.impl.listmap;

import dev.webfx.platform.json.*;
import dev.webfx.platform.util.Numbers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public interface ListMapBasedJsonElement extends JsonElement {

    @Override
    default Object createNativeObject() {
        return new LinkedHashMap<>();
    }

    @Override
    default Object createNativeArray() {
        return new ArrayList();
    }

    @Override
    default JsonObject nativeToJavaJsonObject(Object nativeObject) {
        if (nativeObject == null || nativeObject instanceof JsonObject)
            return (JsonObject) nativeObject;
        return new MapJsonObject((Map) nativeObject);
    }

    @Override
    default JsonArray nativeToJavaJsonArray(Object nativeArray) {
        if (nativeArray == null || nativeArray instanceof JsonArray)
            return (JsonArray) nativeArray;
        return new ListJsonArray((List) nativeArray);
    }

    @Override
    default ElementType getNativeElementType(Object nativeElement) {
        if (nativeElement == null)
            return ElementType.NULL;
        if (nativeElement instanceof Map || nativeElement instanceof ReadOnlyJsonObject)
            return ElementType.OBJECT;
        if (nativeElement instanceof List || nativeElement instanceof ReadOnlyJsonArray)
            return ElementType.ARRAY;
        if (nativeElement instanceof Boolean)
            return ElementType.NUMBER;
        if (nativeElement instanceof String)
            return ElementType.STRING;
        if (Numbers.isNumber(nativeElement))
            return ElementType.NUMBER;
        return ElementType.UNDEFINED;
    }
}
