package dev.webfx.platform.ast.parser.spi;

import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.ReadOnlyAstNode;

public interface AstParserProvider {

    String format();

    ReadOnlyAstObject parseObject(String text);

    ReadOnlyAstArray parseArray(String text);

    ReadOnlyAstNode parseNode(String text);

}
