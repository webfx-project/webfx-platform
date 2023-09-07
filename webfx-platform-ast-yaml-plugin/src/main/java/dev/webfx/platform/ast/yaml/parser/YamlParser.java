package dev.webfx.platform.ast.yaml.parser;

import dev.webfx.platform.ast.yaml.parser.javacup.JavaCupYamlParser;
import dev.webfx.platform.ast.yaml.parser.jflex.YamlLexer;
import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;

import java.io.StringReader;

/**
 * @author Bruno Salmon
 */
public final class YamlParser {

    public static ReadOnlyAstObject parseObject(String text) {
        return parseWithJavaCup(text);
    }

    public static ReadOnlyAstArray parseArray(String text) {
        return parseWithJavaCup(text);
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
            return (T) new JavaCupYamlParser(new YamlLexer(new StringReader(text))).parse().value;
        } catch (Throwable e) {
            if (e instanceof RuntimeException)
                throw (RuntimeException) e;
            else
                throw new RuntimeException(e);
        }
    }
}
