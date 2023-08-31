package dev.webfx.platform.conf.impl;

import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;

/**
 * @author Bruno Salmon
 */
public final class RootConfig extends ConfigImpl {

    public RootConfig(ReadOnlyKeyObject rootKeyObject) {
        super(rootKeyObject);
    }

    @Override
    public RootConfig getRoot() {
        return this;
    }

}
