package dev.webfx.platform.conf.impl;

import dev.webfx.platform.conf.Config;

/**
 * Usage:
 *
 * try (ThreadLocalConfigContext context = ThreadLocalConfigContext.open(config)) {
 *      ...
 *      // Config can then be retrieved in another class (ex: ConfigVariablesResolver) as follow:
 *      Config config = ThreadLocalConfigContext.getThreadLocalConfig();
 *      ...
 * }
 *
 * @author Bruno Salmon
 */
public class ThreadLocalConfigContext implements AutoCloseable {

    private static final ThreadLocal<Config> configThreadLocal = new ThreadLocal<>();

    private final Config previousConfig = configThreadLocal.get();

    private ThreadLocalConfigContext(Config threadLocalConfig) {
        configThreadLocal.set(threadLocalConfig);
    }

    @Override
    public void close() {
        configThreadLocal.set(previousConfig);
    }

    public static ThreadLocalConfigContext open(Config threadLocalConfig) {
        return threadLocalConfig == null ? null : new ThreadLocalConfigContext(threadLocalConfig);
    }

    public static Config getThreadLocalConfig() {
        return configThreadLocal.get();
    }
}

