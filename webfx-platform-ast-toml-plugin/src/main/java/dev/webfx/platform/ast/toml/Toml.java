package dev.webfx.platform.ast.toml;

import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstNode;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.toml.formatter.TomlFormatterProvider;
import dev.webfx.platform.ast.toml.parser.javacup.JavaCupTomlParser;
import dev.webfx.platform.ast.toml.parser.jflex.TomlLexer;

import java.io.StringReader;

/**
 * @author Bruno Salmon
 */
public final class Toml {

    private Toml() {}

    public static ReadOnlyAstObject parseObjectSilently(String text) {
        try {
            return parseObject(text);
        } catch (Exception e) {
            return null;
        }
    }

    public static ReadOnlyAstObject parseObject(String text) {
        return parseAny(text);
    }


    public static ReadOnlyAstArray parseArraySilently(String text) {
        try {
            return parseArray(text);
        } catch (Exception e) {
            return null;
        }
    }

    public static ReadOnlyAstArray parseArray(String text) {
        return parseAny(text);
    }

    public static ReadOnlyAstNode parseNode(String text) {
        return parseAny(text);
    }

    public static <T> T parseAny(String text) {
        return parseWithJavaCup(text);
    }

    private static <T> T parseWithJavaCup(String text) {
        if (text == null)
            return null;
        if (!text.endsWith("\n"))
            text = text + "\n";
        try {
            return (T) new JavaCupTomlParser(new TomlLexer(new StringReader(text))).parse().value;
        } catch (Throwable e) {
            throw new RuntimeException("Toml parsing error: '" +  e.getMessage() + "' while parsing following text:\n" + text);
        }
    }

    public static String formatNode(ReadOnlyAstNode node) {
        return TomlFormatterProvider.INSTANCE.formatNode(node);
    }

    public static String formatArray(ReadOnlyAstArray array) {
        return TomlFormatterProvider.INSTANCE.formatArray(array);
    }

    public static String formatAny(Object object) {
        return TomlFormatterProvider.INSTANCE.formatElement(object);
    }

}