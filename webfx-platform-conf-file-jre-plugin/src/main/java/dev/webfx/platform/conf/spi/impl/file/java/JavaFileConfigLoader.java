package dev.webfx.platform.conf.spi.impl.file.java;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.conf.Config;
import dev.webfx.platform.conf.ConfigParser;
import dev.webfx.platform.conf.SourcesConfig;
import dev.webfx.platform.conf.impl.ConfigMerger;
import dev.webfx.platform.conf.spi.ConfigLoaderProvider;
import dev.webfx.platform.console.Console;
import dev.webfx.platform.secret.SecretFile;
import dev.webfx.platform.secret.SecretPassphrase;

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
                Console.warn("Configuration directory is not defined! Please specify a configuration value at " + SRC_CONFIG_PATH + "." + SRC_CONFIG_DIR_KEY);
            } else {
                File configDirectory = new File(configDirPath);
                if (!configDirectory.exists()) {
                    Console.warn("Specified configuration directory doesn't exist: " + configDirPath);
                } else if (!configDirectory.isDirectory()) {
                    Console.warn("Specified configuration directory is actually not a directory: " + configDirPath);
                } else {
                    Console.log("✓ Configuration directory location: " + configDirPath);
                    readConfigDirectory(configDirectory, fileConfigs);
                    config = ConfigMerger.mergeConfigs(fileConfigs.toArray(Config[]::new));
                }
            }
        } catch (Exception e) {
            Console.error("Error reading config directory!", e);
            return Future.failedFuture(e);
        }
        return Future.succeededFuture(config);
    }

    private void readConfigDirectory(File configDirectory, List<Config> configs) {
        File[] files = configDirectory.listFiles();
        if (files == null || files.length == 0) {
            Console.warn("Configuration directory is empty: " + configDirectory.getAbsolutePath());
        } else {
            for (File file : files) {
                if (file.isHidden()) {
                    Console.warn("Ignoring hidden config file " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    readConfigDirectory(file, configs);
                } else {
                    Path path = file.toPath();
                    boolean encrypted = SecretFile.isSecretFileName(file.getName());
                    try {
                        String fileContent = new String(Files.readAllBytes(path));
                        if (encrypted) {
                            // An encrypted config file: it is decrypted here, and the configuration machinery then
                            // sees it under its name without the .secret extension, so its format (properties, json,
                            // yaml) and the config path it contributes to are read from that name as usual.
                            path = path.resolveSibling(SecretFile.plainFileName(file.getName()));
                            if (Files.exists(path)) {
                                Console.log("⚠️ Both " + file.getName() + " and its decrypted twin " + path.getFileName()
                                            + " are present: the decrypted one also loads, and whichever is read last wins."
                                            + " Delete it once its content is in the encrypted file.");
                            }
                            fileContent = SecretPassphrase.decrypt(fileContent, file.getName());
                        }
                        Config fileConfig = ConfigParser.parseConfigFile(fileContent, path.toString());
                        configs.add(fileConfig);
                    } catch (Exception | LinkageError e) {
                        Console.error("❌ Could not read config file " + file.getAbsolutePath()
                                      + " — the configuration it holds is MISSING", e);
                        // An encrypted file that won't open is not a config file with a typo in it: it is the secrets
                        // of this installation being absent, and continuing would mean running on whatever the
                        // application does when its credentials are missing. So the whole configuration fails to load:
                        // nothing waiting on it is called, so the application initialises none of what it configures
                        // and serves nothing, with the cause logged above.
                        // LinkageError is caught as well: decrypting reaches code that a Java runtime built without
                        // java.desktop can't load, and that must be reported the same way rather than escaping raw.
                        if (encrypted)
                            throw new IllegalStateException("Could not read encrypted config file " + file.getAbsolutePath(), e);
                    }
                }
            }
        }
    }
}
