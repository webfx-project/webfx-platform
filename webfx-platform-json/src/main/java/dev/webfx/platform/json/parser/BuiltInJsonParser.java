package dev.webfx.platform.json.parser;

import dev.webfx.platform.json.JsonArray;
import dev.webfx.platform.json.JsonObject;
import dev.webfx.platform.json.parser.javacup.JavaCupJsonParser;
import dev.webfx.platform.json.parser.jflex.JsonLexer;

import java.io.StringReader;

/**
 * @author Bruno Salmon
 */
public final class BuiltInJsonParser {

    public static JsonObject parseJsonObject(String json) {
        return parseWithJavaCup(json);
    }

    public static JsonArray parseJsonArray(String json) {
        return parseWithJavaCup(json);
    }

    private static <T> T parseWithJavaCup(String json) {
        if (json == null)
            return null;
        try {
            return (T) new JavaCupJsonParser(new JsonLexer(new StringReader(json))).parse().value;
        } catch (Throwable e) {
            if (e instanceof RuntimeException)
                throw (RuntimeException) e;
            else
                throw new RuntimeException(e);
        }
    }
}
