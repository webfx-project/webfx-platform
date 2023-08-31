package dev.webfx.platform.conf.impl;

import dev.webfx.platform.conf.Config;
import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;
import dev.webfx.platform.util.keyobject.util.TreeUtil;

/**
 * @author Bruno Salmon
 */
public final class ConfigMerger {

    public static Config mergeConfigs(Config... configs) {
        ReadOnlyKeyObject mergedConfigs = TreeUtil.mergeKeyObjects(configs);
        if (mergedConfigs == null || mergedConfigs instanceof Config)
            return (Config) mergedConfigs;
        return new RootConfig(mergedConfigs);
    }

}
