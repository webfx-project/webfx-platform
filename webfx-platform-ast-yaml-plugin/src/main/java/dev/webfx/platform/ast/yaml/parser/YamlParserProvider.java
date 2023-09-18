package dev.webfx.platform.ast.yaml.parser;

import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.ReadOnlyAstNode;
import dev.webfx.platform.ast.spi.parser.AstParserProvider;
import dev.webfx.platform.ast.yaml.Yaml;

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
        return Yaml.parseObject(text);
    }

    @Override
    public ReadOnlyAstArray parseArray(String text) {
        return Yaml.parseArray(text);
    }

    @Override
    public ReadOnlyAstNode parseNode(String text) {
        return parseObject(text);
    }

    @Override
    public <T> T parseAny(String text) {
        return Yaml.parseAny(text);
    }
}
