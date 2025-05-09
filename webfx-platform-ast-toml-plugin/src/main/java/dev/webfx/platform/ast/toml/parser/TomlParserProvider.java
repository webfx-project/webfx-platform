package dev.webfx.platform.ast.toml.parser;

import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstNode;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.toml.Toml;
import dev.webfx.platform.ast.spi.parser.AstParserProvider;

/**
 * @author Bruno Salmon
 */
public final class TomlParserProvider implements AstParserProvider {

    @Override
    public String format() {
        return "toml";
    }

    @Override
    public ReadOnlyAstObject parseObject(String text) {
        return Toml.parseObject(text);
    }

    @Override
    public ReadOnlyAstArray parseArray(String text) {
        return Toml.parseArray(text);
    }

    @Override
    public ReadOnlyAstNode parseNode(String text) {
        return parseObject(text);
    }

    @Override
    public <T> T parseAny(String text) {
        return Toml.parseAny(text);
    }
}