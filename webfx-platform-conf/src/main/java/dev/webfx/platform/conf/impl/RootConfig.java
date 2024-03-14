package dev.webfx.platform.conf.impl;

import dev.webfx.platform.ast.ReadOnlyAstObject;

/**
 * @author Bruno Salmon
 */
public final class RootConfig extends ConfigImpl {

    public RootConfig(ReadOnlyAstObject rootAstObject) {
        super(rootAstObject);
    }

    @Override
    public RootConfig getRoot() {
        return this;
    }

}
