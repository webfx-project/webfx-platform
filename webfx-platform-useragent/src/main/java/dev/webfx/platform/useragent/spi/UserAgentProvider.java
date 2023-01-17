package dev.webfx.platform.useragent.spi;

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

}
