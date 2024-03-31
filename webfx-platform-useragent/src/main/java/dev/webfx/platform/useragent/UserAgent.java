package dev.webfx.platform.useragent;

import dev.webfx.platform.useragent.spi.UserAgentProvider;
import dev.webfx.platform.service.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public final class UserAgent {

    private UserAgent() {}

    private static UserAgentProvider getProvider() {
        return SingleServiceProvider.getProvider(UserAgentProvider.class, () -> ServiceLoader.load(UserAgentProvider.class));
    }

    public static String getUserAgentName() {
        return getProvider().getUserAgentName();
    }

    public static boolean isClient() {
        return getProvider().isClient();
    }

    public static boolean isServer() {
        return getProvider().isServer();
    }

    public static boolean isBrowser() {
        return getProvider().isBrowser();
    }

    public static boolean isJre() {
        return getProvider().isJre();
    }

    public static boolean isNative() {
        return getProvider().isNative();
    }

    public static BrowserType getBrowserType() {
        return getProvider().getBrowserType();
    }

    public static String getBrowserVersion() {
        return getProvider().getBrowserVersion();
    }

    public static int getBrowserMajorVersion() {
        return getProvider().getBrowserMajorVersion();
    }

    public static boolean isChrome() {
        return getBrowserType() == BrowserType.CHROME;
    }

    public static boolean isFireFox() {
        return getBrowserType() == BrowserType.FIREFOX;
    }

    public static boolean isSafari() {
        return getBrowserType() == BrowserType.SAFARI;
    }

    public static boolean isEdge() {
        return getBrowserType() == BrowserType.EDGE;
    }

    public static boolean isOpera() {
        return getBrowserType() == BrowserType.OPERA;
    }

    public static boolean isUnknownBrowser() {
        return getBrowserType() == BrowserType.UNKNOWN;
    }

}

