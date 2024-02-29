package dev.webfx.platform.conf.zero;

import java.time.Instant;

/**
 * @author Bruno Salmon
 */
public final class ZeroConfig {

    private ZeroConfig() {}

    public static String lookupString(String configPath, String key) {
        return lookupString(configPath, key, null);
    }

    public static String lookupString(String configPath, String key, String defaultValue) {
        return defaultValue;
    }

    public static Boolean lookupBoolean(String configPath, String key, Boolean defaultValue) {
        return defaultValue;
    }

    public static Integer lookupInteger(String configPath, String key, Integer defaultValue) {
        return defaultValue;
    }

    public static Long lookupLong(String configPath, String key, Long defaultValue) {
        return defaultValue;
    }

    public static Double lookupDouble(String configPath, String key, Double defaultValue) {
        return defaultValue;
    }

    public static Instant lookupInstant(String configPath, String key, Instant defaultValue) {
        return defaultValue;
    }

}
