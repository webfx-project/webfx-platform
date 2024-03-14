package dev.webfx.platform.ast.spi.factory.impl.generic;

import dev.webfx.platform.ast.AstArray;
import dev.webfx.platform.ast.AstObject;
import dev.webfx.platform.ast.spi.factory.AstFactoryProvider;

/**
 * @author Bruno Salmon
 */
public class GenericAstFactoryProvider implements AstFactoryProvider {

    @Override
    public AstObject createObject() {
        return new MapAstObject();
    }

    @Override
    public AstArray createArray() {
        return new ListAstArray();
    }
}
