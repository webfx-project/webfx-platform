package dev.webfx.platform.util.keyobject.formatter.spi;

import dev.webfx.platform.util.keyobject.ReadOnlyIndexedArray;
import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;
import dev.webfx.platform.util.keyobject.ReadOnlyAstNode;

/**
 * @author Bruno Salmon
 */
public interface AstFormatterProvider {

    String format();

    default String formatObject(ReadOnlyKeyObject keyObject) {
        return formatNode(keyObject);
    }

    default String formatArray(ReadOnlyIndexedArray indexedArray) {
        return formatNode(indexedArray);
    }

    String formatNode(ReadOnlyAstNode treeNode);

}
