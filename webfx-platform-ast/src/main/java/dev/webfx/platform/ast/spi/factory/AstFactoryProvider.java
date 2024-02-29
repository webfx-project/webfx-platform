package dev.webfx.platform.ast.spi.factory;

import dev.webfx.platform.ast.AstArray;
import dev.webfx.platform.ast.AstObject;

/**
 * @author Bruno Salmon
 */
public interface AstFactoryProvider {

    AstObject createObject();

    AstArray createArray();

}
