package dev.webfx.platform.conf.impl;

import dev.webfx.platform.conf.Config;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.AST;

/**
 * @author Bruno Salmon
 */
public final class ConfigMerger {

    public static Config mergeConfigs(Config... configs) {
        ReadOnlyAstObject mergedConfigs = AST.mergeAstObjects(configs);
        if (mergedConfigs == null || mergedConfigs instanceof Config)
            return (Config) mergedConfigs;
        return new RootConfig(mergedConfigs);
    }

}
