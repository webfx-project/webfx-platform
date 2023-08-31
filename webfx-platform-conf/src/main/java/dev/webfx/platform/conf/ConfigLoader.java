package dev.webfx.platform.conf;

import dev.webfx.platform.async.Batch;
import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.FutureBroadcaster;
import dev.webfx.platform.async.Promise;
import dev.webfx.platform.conf.impl.ConfigMerger;
import dev.webfx.platform.conf.spi.ConfigLoaderProvider;
import dev.webfx.platform.util.Arrays;
import dev.webfx.platform.util.serviceloader.MultipleServiceProviders;

import java.util.List;
import java.util.ServiceLoader;
import java.util.function.Consumer;

/**
 * @author Bruno Salmon
 */
public class ConfigLoader {

    public static void onConfigLoaded(Consumer<Config> configConsumer) {
        onConfigLoaded(configConsumer, false);
    }

    public static void onConfigLoadedOrChanged(Consumer<Config> configConsumer) {
        onConfigLoaded(configConsumer, false);
    }

    public static void onConfigLoaded(Consumer<Config> configConsumer, boolean onChangesToo) {
        onConfigLoaded(null, configConsumer, onChangesToo);
    }

    public static void onConfigLoaded(String path, Consumer<Config> configConsumer) {
        onConfigLoaded(path, configConsumer, false);
    }

    public static void onConfigLoadedOrChanged(String path, Consumer<Config> configConsumer) {
        onConfigLoaded(path, configConsumer, false);
    }

    public static void onConfigLoaded(String path, Consumer<Config> configConsumer, boolean onChangesToo) {
        INITIAL_LOADER.newClient().onSuccess(rootConfig -> configConsumer.accept(rootConfig.childConfigAt(path)));
    }

    private static final FutureBroadcaster<Config> INITIAL_LOADER = new FutureBroadcaster<>(loadRootConfig());

    private static List<ConfigLoaderProvider> getProviders() {
          return MultipleServiceProviders.getProviders(ConfigLoaderProvider.class, () -> ServiceLoader.load(ConfigLoaderProvider.class));
    }

    private static Config ROOT_CONFIG;

    public static Config getRootConfig() {
        return ROOT_CONFIG != null ? ROOT_CONFIG : SourcesConfig.getSourcesRootConfig();
    }

    private static Future<Config> loadRootConfig() {
        Promise<Config> promise = Promise.promise();
        new Batch<>(getProviders().toArray(new ConfigLoaderProvider[0]))
                .executeParallel(Config[]::new, ConfigLoaderProvider::loadConfig)
                .onFailure(promise::fail)
                .onSuccess(batch -> {
                    Config[] sourcesConfig = { SourcesConfig.getSourcesRootConfig() };
                    Config[] loadedAndSourcesConfig = Arrays.concat(Config[]::new, batch.getArray(), sourcesConfig);
                    ROOT_CONFIG = ConfigMerger.mergeConfigs(loadedAndSourcesConfig);
                    promise.complete(ROOT_CONFIG);
                });
        return promise.future();
    }

}
