package dev.webfx.platform.ast.json;

import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstNode;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.parser.spi.AstParserProvider;

/**
 * @author Bruno Salmon
 */
public class JsonAstParserProvider implements AstParserProvider {

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
        return Json.parseElement(text);
    }

    @Override
    public <T> T parseAny(String text) {
        return null;
    }
}
