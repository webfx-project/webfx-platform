package dev.webfx.platform.ast.json.spi;

import dev.webfx.platform.ast.json.JsonArray;
import dev.webfx.platform.ast.json.JsonFormatter;
import dev.webfx.platform.ast.json.JsonParser;
import dev.webfx.platform.ast.json.JsonObject;

/**
 * @author Bruno Salmon
 */
public interface JsonProvider extends JsonParser, JsonFormatter {

    /**
     * Create an empty native object.
     * @return a new empty native object
     */
    Object createNativeObject();

    /**
     * Create an empty native array.
     * @return a new empty native array
     */
    Object createNativeArray();

    /**
     * Create an empty json object.
     * @return a new empty json object
     */
    default JsonObject createJsonObject() {
        return nativeToJavaJsonObject(createNativeObject());
    }

    /**
     * Create an empty json array.
     * @return a new empty json array
     */
    default JsonArray createJsonArray() {
        return nativeToJavaJsonArray(createNativeArray());
    }

}
