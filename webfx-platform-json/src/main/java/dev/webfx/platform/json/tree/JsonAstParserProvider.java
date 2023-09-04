package dev.webfx.platform.json.tree;

import dev.webfx.platform.json.Json;
import dev.webfx.platform.util.keyobject.ReadOnlyIndexedArray;
import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;
import dev.webfx.platform.util.keyobject.ReadOnlyAstNode;
import dev.webfx.platform.util.keyobject.parser.spi.AstParserProvider;

/**
 * @author Bruno Salmon
 */
public class JsonAstParserProvider implements AstParserProvider {

    @Override
    public String format() {
        return "json";
    }

    @Override
    public ReadOnlyKeyObject parseObject(String text) {
        return Json.parseObject(text);
    }

    @Override
    public ReadOnlyIndexedArray parseArray(String text) {
        return Json.parseArray(text);
    }

    @Override
    public ReadOnlyAstNode parseNode(String text) {
        return Json.parseElement(text);
    }
}
