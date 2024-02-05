package dev.webfx.platform.useragent.spi;

import dev.webfx.platform.useragent.BrowserType;

public interface UserAgentProvider {

    String getUserAgentName();

    boolean isClient();

    default boolean isServer() {
        return !isClient();
    }

    boolean isBrowser();

    default boolean isJre() {
        return !isBrowser() && !isNative();
    }

    boolean isNative();

    default BrowserType getBrowserType() { return null; }

    default String getBrowserVersion() { return null; }

    default int getBrowserMajorVersion() { return -1; }

}
