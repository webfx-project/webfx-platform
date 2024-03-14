package dev.webfx.platform.conf.impl;

import dev.webfx.platform.ast.ReadOnlyAstObject;

/**
 * @author Bruno Salmon
 */
public final class ChildConfig extends ConfigImpl {

    private final RootConfig rootConfig;

    public ChildConfig(RootConfig rootConfig, ReadOnlyAstObject childAstObject) {
        super(childAstObject);
        this.rootConfig = rootConfig;
    }

    @Override
    public RootConfig getRoot() {
        return rootConfig;
    }


}
