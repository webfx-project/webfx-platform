package dev.webfx.platform.ast.json.parser;

import dev.webfx.platform.ast.json.JsonArray;
import dev.webfx.platform.ast.json.parser.jflex.JsonLexer;
import dev.webfx.platform.ast.json.JsonObject;
import dev.webfx.platform.ast.json.parser.javacup.JavaCupJsonParser;

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
