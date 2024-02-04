package dev.webfx.platform.useragent;

import dev.webfx.platform.useragent.spi.UserAgentProvider;
import dev.webfx.platform.util.serviceloader.SingleServiceProvider;

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

    public static boolean isChrome() {
        return getProvider().isChrome();
    }

    public static boolean isFireFox() {
        return getProvider().isFireFox();
    }

    public static boolean isSafari() {
        return getProvider().isSafari();
    }

    public static boolean isEdge() {
        return getProvider().isEdge();
    }

    public static boolean isOtherBrowser() {
        return getProvider().isOtherBrowser();
    }

    public static String getBrowserVersion() {
        return getProvider().getBrowserVersion();
    }

    public static int getBrowserMajorVersion() {
        return getProvider().getBrowserMajorVersion();
    }

}

