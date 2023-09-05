package dev.webfx.platform.json;

import dev.webfx.platform.util.keyobject.ReadOnlyIndexedArray;
import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;
import dev.webfx.platform.util.keyobject.parser.spi.TreeParserProvider;

/**
 * @author Bruno Salmon
 */
public class JsonTreeParserProvider implements TreeParserProvider {

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
}
