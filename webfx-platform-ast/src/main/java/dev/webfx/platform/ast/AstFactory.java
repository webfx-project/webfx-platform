package dev.webfx.platform.ast;

import dev.webfx.platform.ast.impl.listmap.ListMapAstFactory;

/**
 * @author Bruno Salmon
 */
public interface AstFactory {

    AstObject createObject();

    AstArray createArray();

    static AstFactory get() {
        return ListMapAstFactory.getInstance();
    }

}
