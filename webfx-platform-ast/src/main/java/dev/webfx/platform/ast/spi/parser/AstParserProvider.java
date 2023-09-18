package dev.webfx.platform.ast.spi.parser;

import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.ReadOnlyAstNode;

public interface AstParserProvider {

    String format();

    default ReadOnlyAstObject parseObject(String text) {
        return parseAny(text);
    }

    default ReadOnlyAstArray parseArray(String text) {
        return parseAny(text);
    }

    default ReadOnlyAstNode parseNode(String text) {
        return parseAny(text);
    }

    <T> T parseAny(String text);

}
