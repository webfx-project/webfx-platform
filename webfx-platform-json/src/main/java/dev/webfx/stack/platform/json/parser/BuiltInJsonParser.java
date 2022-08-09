package dev.webfx.stack.platform.json.parser;

import dev.webfx.stack.platform.json.WritableJsonArray;
import dev.webfx.stack.platform.json.WritableJsonObject;
import dev.webfx.stack.platform.json.parser.javacup.JavaCupJsonParser;
import dev.webfx.stack.platform.json.parser.jflex.JsonLexer;

import java.io.StringReader;

/**
 * @author Bruno Salmon
 */
public final class BuiltInJsonParser {

    public static WritableJsonObject parseJsonObject(String json) {
        return parseWithJavaCup(json);
    }

    public static WritableJsonArray parseJsonArray(String json) {
        return parseWithJavaCup(json);
    }

    private static <T> T parseWithJavaCup(String json) {
        try {
            return (T) new JavaCupJsonParser(new JsonLexer(new StringReader(json))).parse().value;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}
