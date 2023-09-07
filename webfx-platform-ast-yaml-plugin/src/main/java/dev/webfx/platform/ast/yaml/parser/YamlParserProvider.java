package dev.webfx.platform.ast.yaml.parser;

import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.ReadOnlyAstNode;
import dev.webfx.platform.ast.parser.spi.AstParserProvider;

/**
 * @author Bruno Salmon
 */
public final class YamlParserProvider implements AstParserProvider {

    @Override
    public String format() {
        return "yaml";
    }

    @Override
    public ReadOnlyAstObject parseObject(String text) {
        return YamlParser.parseObject(text);
    }

    @Override
    public ReadOnlyAstArray parseArray(String text) {
        return YamlParser.parseArray(text);
    }

    @Override
    public ReadOnlyAstNode parseNode(String text) {
        return parseObject(text);
    }

    @Override
    public <T> T parseAny(String text) {
        return YamlParser.parseAny(text);
    }
}
