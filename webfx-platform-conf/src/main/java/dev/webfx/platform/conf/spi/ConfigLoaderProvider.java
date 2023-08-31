package dev.webfx.platform.conf.spi;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.conf.Config;

public interface ConfigLoaderProvider {

    Future<Config> loadConfig();

}
