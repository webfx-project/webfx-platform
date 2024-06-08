package dev.webfx.platform.conf.impl;

import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.conf.Config;

/**
 * @author Bruno Salmon
 */
public final class ChildConfig extends ConfigImpl {

    private final RootConfig rootConfig;

    public ChildConfig(Config parentConfig, ReadOnlyAstObject childAstObject) {
        super(childAstObject, parentConfig);
        this.rootConfig = parentConfig.getRoot();
    }

    @Override
    public RootConfig getRoot() {
        return rootConfig;
    }

}
