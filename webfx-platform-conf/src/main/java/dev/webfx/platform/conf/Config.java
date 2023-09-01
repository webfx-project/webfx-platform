package dev.webfx.platform.conf;

import dev.webfx.platform.conf.impl.RootConfig;
import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;

/**
 * @author Bruno Salmon
 */
public interface Config extends ReadOnlyKeyObject {

    RootConfig getRoot();

    Config childConfigAt(String path);

}
