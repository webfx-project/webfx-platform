package dev.webfx.platform.json.parser;

import dev.webfx.platform.json.parser.javacup.JavaCupJsonParser;
import dev.webfx.platform.json.parser.jflex.JsonLexer;
import dev.webfx.platform.json.WritableJsonArray;
import dev.webfx.platform.json.WritableJsonObject;

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
            if (e instanceof RuntimeException)
                throw (RuntimeException) e;
            else
                throw new RuntimeException(e);
        }
    }
}
