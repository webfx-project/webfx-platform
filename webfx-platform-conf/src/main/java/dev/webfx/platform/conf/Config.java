package dev.webfx.platform.conf;

import dev.webfx.platform.conf.impl.RootConfig;
import dev.webfx.platform.ast.ReadOnlyAstObject;

/**
 * @author Bruno Salmon
 */
public interface Config extends ReadOnlyAstObject {

    RootConfig getRoot();

    Config parentConfig();

    Config childConfigAt(String path);

}
