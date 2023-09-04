package dev.webfx.platform.conf;

import dev.webfx.platform.resource.Resource;

/**
 * @author Bruno Salmon
 */
public final class SourcesConfig {

    public final static String SRC_ROOT_CONF_PACKAGE = "dev.webfx.platform.conf";
    public final static String SRC_ROOT_CONF_RESOURCE_FOLDER = SRC_ROOT_CONF_PACKAGE.replace('.', '/');
    private final static String SRC_ROOT_CONF_RESOURCE_FILE_NAME_WITHOUT_EXTENSION = "src-root";
    private final static String SRC_ROOT_CONF_RESOURCE_FILE_PATH_WITHOUT_EXTENSION = SRC_ROOT_CONF_RESOURCE_FOLDER + "/" + SRC_ROOT_CONF_RESOURCE_FILE_NAME_WITHOUT_EXTENSION;
    public final static String PROPERTIES_SRC_ROOT_CONF_RESOURCE_FILE_PATH = SRC_ROOT_CONF_RESOURCE_FILE_PATH_WITHOUT_EXTENSION + ".properties";
    public final static String JSON_SRC_ROOT_CONF_RESOURCE_FILE_PATH = SRC_ROOT_CONF_RESOURCE_FILE_PATH_WITHOUT_EXTENSION + ".json";
    private static Config sourcesRootConfig;

    public static Config getSourcesRootConfig() {
        if (sourcesRootConfig == null) {
            String resourcePath = PROPERTIES_SRC_ROOT_CONF_RESOURCE_FILE_PATH;
            String configText = Resource.getText(resourcePath);
            if (configText == null) {
                configText = Resource.getText(resourcePath = JSON_SRC_ROOT_CONF_RESOURCE_FILE_PATH);
                if (configText == null)
                    throw new RuntimeException("❌ No sources route configuration found!");
            }
            sourcesRootConfig = ConfigParser.parseConfigFile(configText, resourcePath);
        }
        return sourcesRootConfig;
    }

}
