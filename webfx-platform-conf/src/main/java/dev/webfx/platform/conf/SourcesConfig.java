package dev.webfx.platform.conf;

import dev.webfx.platform.resource.Resource;

/**
 * @author Bruno Salmon
 */
public final class SourcesConfig {

    public final static String SRC_ROOT_CONF_PACKAGE = "dev.webfx.platform.conf";
    public final static String SRC_ROOT_CONF_RESOURCE_FOLDER = SRC_ROOT_CONF_PACKAGE.replace('.', '/');
    public final static String SRC_ROOT_CONF_RESOURCE_FILE_NAME = "src-root.properties";
    public final static String SRC_ROOT_CONF_RESOURCE_FILE_PATH = SRC_ROOT_CONF_RESOURCE_FOLDER + "/" + SRC_ROOT_CONF_RESOURCE_FILE_NAME;
    private static Config sourcesRootConfig;

    public static Config getSourcesRootConfig() {
        if (sourcesRootConfig == null) {
            String configText = Resource.getText(SRC_ROOT_CONF_RESOURCE_FILE_PATH);
            if (configText == null) {
                throw new RuntimeException("❌ No sources route configuration found!");
            }
            sourcesRootConfig = ConfigParser.parseFileConfig(configText, SRC_ROOT_CONF_RESOURCE_FILE_PATH);
        }
        return sourcesRootConfig;
    }

}
