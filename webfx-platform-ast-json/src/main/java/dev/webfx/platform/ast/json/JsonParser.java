package dev.webfx.platform.ast.json;

import dev.webfx.platform.ast.json.parser.BuiltInJsonParser;

/**
 * @author Bruno Salmon
 */
public interface JsonParser extends NativeJsonWrapper {

    /**
     * Parse a text into a native object.
     * @param text the text to parse
     * @return the native object
     */
    default Object parseNativeObject(String text) {
        return BuiltInJsonParser.parseJsonObject(text);
    }

    /**
     * Parse a text into a native array.
     * @param text the text to parse
     * @return the native array
     */
    default Object parseNativeArray(String text) {
        return BuiltInJsonParser.parseJsonArray(text);
    }

    /**
     * Parse a text into a json object.
     * @param text the text to parse
     * @return the json object
     */
    default JsonObject parseObject(String text) {
        return nativeToJavaJsonObject(parseNativeObject(text));
    }

    /**
     * Parse a text into a json array.
     * @param text the text to parse
     * @return the json array
     */
    default JsonArray parseArray(String text) {
        return nativeToJavaJsonArray(parseNativeArray(text));
    }
}
