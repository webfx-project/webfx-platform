package dev.webfx.platform.ast.xml.parser;

import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstNode;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.xml.Xml;
import dev.webfx.platform.ast.spi.parser.AstParserProvider;

/**
 * @author Bruno Salmon
 */
public final class XmlParserProvider implements AstParserProvider {

    @Override
    public String format() {
        return "xml";
    }

    @Override
    public ReadOnlyAstObject parseObject(String text) {
        return Xml.parseObject(text);
    }

    @Override
    public ReadOnlyAstArray parseArray(String text) {
        return Xml.parseArray(text);
    }

    @Override
    public ReadOnlyAstNode parseNode(String text) {
        return parseObject(text);
    }

    @Override
    public <T> T parseAny(String text) {
        return Xml.parseAny(text);
    }
}