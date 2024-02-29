package dev.webfx.platform.ast.json.parser;

import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstNode;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.json.Json;
import dev.webfx.platform.ast.spi.parser.AstParserProvider;

/**
 * @author Bruno Salmon
 */
public final class JsonParserProvider implements AstParserProvider {

    @Override
    public String format() {
        return "json";
    }

    @Override
    public ReadOnlyAstObject parseObject(String text) {
        return Json.parseObject(text);
    }

    @Override
    public ReadOnlyAstArray parseArray(String text) {
        return Json.parseArray(text);
    }

    @Override
    public ReadOnlyAstNode parseNode(String text) {
        return parseObject(text);
    }

    @Override
    public <T> T parseAny(String text) {
        return Json.parseAny(text);
    }
}
