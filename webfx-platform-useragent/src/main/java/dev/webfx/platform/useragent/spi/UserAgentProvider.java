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

    default boolean isChrome() { return false; }

    default boolean isFireFox() { return false; }

    default boolean isSafari() { return false; }

    default boolean isEdge() { return false; }

    default boolean isOtherBrowser() { return false; }

    default String getBrowserVersion() { return null; }

    default int getBrowserMajorVersion() { return -1; }

}
