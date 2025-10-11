package dev.webfx.platform.conf.spi.impl.file.java;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.conf.Config;
import dev.webfx.platform.conf.ConfigParser;
import dev.webfx.platform.conf.SourcesConfig;
import dev.webfx.platform.conf.impl.ConfigMerger;
import dev.webfx.platform.conf.spi.ConfigLoaderProvider;
import dev.webfx.platform.console.Console;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

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
            List<Config> fileConfigs = new ArrayList<>();
            Config sourcesConfig = SourcesConfig.getSourcesRootConfig().childConfigAt(SRC_CONFIG_PATH);
            String configDirPath = sourcesConfig.getString(SRC_CONFIG_DIR_KEY);
            if (configDirPath == null) {
                Console.log("⚠️ Configuration directory is not defined! Please specify a configuration value at " + SRC_CONFIG_PATH + "." + SRC_CONFIG_DIR_KEY);
            } else {
                File configDirectory = new File(configDirPath);
                if (!configDirectory.exists()) {
                    Console.log("⚠️ Specified configuration directory doesn't exist: " + configDirPath);
                } else if (!configDirectory.isDirectory()) {
                    Console.log("⚠️ Specified configuration directory is actually not a directory: " + configDirPath);
                } else {
                    Console.log("✓ Configuration directory location: " + configDirPath);
                    readConfigDirectory(configDirectory, fileConfigs);
                    config = ConfigMerger.mergeConfigs(fileConfigs.toArray(Config[]::new));
                }
            }
        } catch (Exception e) {
            Console.log("⛔️️ Error reading config directory!", e);
            return Future.failedFuture(e);
        }
        return Future.succeededFuture(config);
    }

    private void readConfigDirectory(File configDirectory, List<Config> configs) {
        File[] files = configDirectory.listFiles();
        if (files == null || files.length == 0) {
            Console.log("⚠️ Configuration directory is empty: " + configDirectory.getAbsolutePath());
        } else {
            for (File file : files) {
                if (file.isHidden()) {
                    Console.log("⚠️ Ignoring hidden config file " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    readConfigDirectory(file, configs);
                } else {
                    Path path = file.toPath();
                    try {
                        String fileContent = new String(Files.readAllBytes(path));
                        Config fileConfig = ConfigParser.parseConfigFile(fileContent, path.toString());
                        configs.add(fileConfig);
                    } catch (Exception e) {
                        Console.log("⛔️️ Error reading config file " + file.getAbsolutePath(), e);
                    }
                }
            }
        }
    }
}
