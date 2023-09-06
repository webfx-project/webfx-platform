package dev.webfx.platform.ast.impl.listmap;

import dev.webfx.platform.ast.AstFactory;
import dev.webfx.platform.ast.AstArray;
import dev.webfx.platform.ast.AstObject;

/**
 * @author Bruno Salmon
 */
public final class ListMapAstFactory implements AstFactory {

    private final static ListMapAstFactory INSTANCE = new ListMapAstFactory();

    public static ListMapAstFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public AstObject createObject() {
        return new MapAstObject();
    }

    @Override
    public AstArray createArray() {
        return new ListAstArray();
    }
}
