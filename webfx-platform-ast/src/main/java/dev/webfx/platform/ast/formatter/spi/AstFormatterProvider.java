package dev.webfx.platform.ast.formatter.spi;

import dev.webfx.platform.ast.ReadOnlyAstNode;
import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;

/**
 * @author Bruno Salmon
 */
public interface AstFormatterProvider {

    String format();

    default String formatObject(ReadOnlyAstObject astObject) {
        return formatNode(astObject);
    }

    default String formatArray(ReadOnlyAstArray astArray) {
        return formatNode(astArray);
    }

    String formatNode(ReadOnlyAstNode treeNode);

}
