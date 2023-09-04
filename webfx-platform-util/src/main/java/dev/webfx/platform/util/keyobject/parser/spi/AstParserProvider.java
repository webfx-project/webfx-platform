package dev.webfx.platform.util.keyobject.parser.spi;

import dev.webfx.platform.util.keyobject.ReadOnlyIndexedArray;
import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;
import dev.webfx.platform.util.keyobject.ReadOnlyAstNode;

public interface AstParserProvider {

    String format();

    ReadOnlyKeyObject parseObject(String text);

    ReadOnlyIndexedArray parseArray(String text);

    ReadOnlyAstNode parseNode(String text);

}
