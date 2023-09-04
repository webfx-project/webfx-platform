package dev.webfx.platform.ast.yaml.parser;

import dev.webfx.platform.util.keyobject.ReadOnlyIndexedArray;
import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;
import dev.webfx.platform.util.keyobject.ReadOnlyAstNode;
import dev.webfx.platform.util.keyobject.parser.spi.AstParserProvider;

/**
 * @author Bruno Salmon
 */
public final class YamlParserProvider implements AstParserProvider {

    @Override
    public String format() {
        return "yaml";
    }

    @Override
    public ReadOnlyKeyObject parseObject(String text) {
        return YamlParser.parseObject(text);
    }

    @Override
    public ReadOnlyIndexedArray parseArray(String text) {
        return YamlParser.parseArray(text);
    }

    @Override
    public ReadOnlyAstNode parseNode(String text) {
        return parseObject(text);
    }
}
