package dev.webfx.platform.util.keyobject.parser.spi;

import dev.webfx.platform.util.keyobject.ReadOnlyIndexedArray;
import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;

public interface TreeParserProvider {

    String format();

    ReadOnlyKeyObject parseObject(String text);

    ReadOnlyIndexedArray parseArray(String text);

}
