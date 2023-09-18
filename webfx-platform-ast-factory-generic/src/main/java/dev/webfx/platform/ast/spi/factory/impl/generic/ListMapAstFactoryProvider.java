package dev.webfx.platform.ast.spi.factory.impl.generic;

import dev.webfx.platform.ast.spi.factory.AstFactoryProvider;
import dev.webfx.platform.ast.AstArray;
import dev.webfx.platform.ast.AstObject;

/**
 * @author Bruno Salmon
 */
public final class ListMapAstFactoryProvider implements AstFactoryProvider {

    private final static ListMapAstFactoryProvider INSTANCE = new ListMapAstFactoryProvider();

    public static ListMapAstFactoryProvider getInstance() {
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
