package dev.webfx.platform.conf.spi.impl.file.java;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.conf.Config;
import dev.webfx.platform.conf.ConfigParser;
import dev.webfx.platform.conf.SourcesConfig;
import dev.webfx.platform.conf.impl.ConfigMerger;
import dev.webfx.platform.conf.spi.ConfigLoaderProvider;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Bruno Salmon
 */
public class JavaFileConfigLoader implements ConfigLoaderProvider {

    private final static String SRC_CONFIG_PATH = "webfx.platform.conf.file";
    private final static String SRC_CONFIG_DIR_KEY = "configDirectory";

    @Override
    public Future<Config> loadConfig() {
        Config config = null;
        try {
            Config sourcesConfig = SourcesConfig.getSourcesRootConfig().childConfigAt(SRC_CONFIG_PATH);
            String configDirPath = sourcesConfig.getString(SRC_CONFIG_DIR_KEY);
            File configurationDirectory = new File(configDirPath);
            File[] files = configurationDirectory.listFiles();
            if (files != null) {
                int n = files.length;
                Config[] configs = new Config[n];
                for (int i = 0; i < n; i++) {
                    Path path = files[i].toPath();
                    String fileContent = new String(Files.readAllBytes(path));
                    configs[i] = ConfigParser.parseFileConfig(fileContent, path.toString());
                }
                config = ConfigMerger.mergeConfigs(configs);
            }
        } catch (Exception e) {
            return Future.failedFuture(e);
        }
        return Future.succeededFuture(config);
    }
}
