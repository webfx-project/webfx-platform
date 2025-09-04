package dev.webfx.platform.ast.xml;

import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstNode;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.xml.formatter.XmlFormatterProvider;
import dev.webfx.platform.ast.xml.parser.javacup.JavaCupXmlParser;
import dev.webfx.platform.ast.xml.parser.jflex.XmlLexer;

import java.io.StringReader;

/**
 * @author Bruno Salmon
 */
public final class Xml {

    private Xml() {}

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
            JavaCupXmlParser parser = new JavaCupXmlParser(new XmlLexer(new StringReader(text)));
            java_cup.runtime.Symbol parseResult = parser.parse();
            if (parseResult == null || parseResult.value == null) {
                throw new RuntimeException("Parser returned null result");
            }
            return (T) parseResult.value;
        } catch (Exception e) {
            throw new RuntimeException("Xml parsing error: '" + (e.getMessage() != null ? e.getMessage() : e.toString()) + "' while parsing following text:\n" + text, e);
        } catch (Error e) {
            throw new RuntimeException("Xml parsing error (fatal): '" + e.getMessage() + "' while parsing following text:\n" + text, e);
        }
    }

    public static String formatNode(ReadOnlyAstNode node) {
        return XmlFormatterProvider.INSTANCE.formatNode(node);
    }

    public static String formatObject(ReadOnlyAstObject object) {
        return XmlFormatterProvider.INSTANCE.formatObject(object);
    }

    public static String formatArray(ReadOnlyAstArray array) {
        return XmlFormatterProvider.INSTANCE.formatArray(array);
    }

    public static String formatAny(Object object) {
        return XmlFormatterProvider.INSTANCE.formatElement(object);
    }

}
