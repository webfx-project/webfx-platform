package dev.webfx.platform.conf.zero;

import dev.webfx.platform.conf.Config;
import dev.webfx.platform.conf.ConfigLoader;

import java.time.Instant;

/**
 * @author Bruno Salmon
 */
public final class ZeroConfig {

    private ZeroConfig() {}

    private static Config configAt(String configPath) {
        return ConfigLoader.getRootConfig().childConfigAt(configPath);
    }

    public static String lookupString(String configPath, String key) {
        return lookupString(configPath, key, null);
    }

    public static String lookupString(String configPath, String key, String defaultValue) {
        Config config = configAt(configPath);
        return config != null ? config.getString(key, defaultValue) : defaultValue;
    }

    public static Boolean lookupBoolean(String configPath, String key, Boolean defaultValue) {
        Config config = configAt(configPath);
        return config != null ? config.getBoolean(key, defaultValue) : defaultValue;
    }

    public static Integer lookupInteger(String configPath, String key, Integer defaultValue) {
        Config config = configAt(configPath);
        return config != null ? config.getInteger(key, defaultValue) : defaultValue;
    }

    public static Long lookupLong(String configPath, String key, Long defaultValue) {
        Config config = configAt(configPath);
        return config != null ? config.getLong(key, defaultValue) : defaultValue;
    }

    public static Double lookupDouble(String configPath, String key, Double defaultValue) {
        Config config = configAt(configPath);
        return config != null ? config.getDouble(key, defaultValue) : defaultValue;
    }

    public static Instant lookupInstant(String configPath, String key, Instant defaultValue) {
        Config config = configAt(configPath);
        return config != null ? config.getInstant(key, defaultValue) : defaultValue;

    }

}
