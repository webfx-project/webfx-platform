package dev.webfx.platform.conf.impl;

import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;

/**
 * @author Bruno Salmon
 */
public final class ChildConfig extends ConfigImpl {

    private final RootConfig rootConfig;

    public ChildConfig(RootConfig rootConfig, ReadOnlyKeyObject childKeyObject) {
        super(childKeyObject);
        this.rootConfig = rootConfig;
    }

    @Override
    public RootConfig getRoot() {
        return rootConfig;
    }


}
