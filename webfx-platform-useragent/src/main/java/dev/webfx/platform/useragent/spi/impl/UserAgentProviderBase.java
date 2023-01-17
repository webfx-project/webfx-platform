package dev.webfx.platform.useragent.spi.impl;

import dev.webfx.platform.useragent.spi.UserAgentProvider;

/**
 * @author Bruno Salmon
 */
public class UserAgentProviderBase implements UserAgentProvider {

    private final String userAgentName;
    private final boolean isClient;
    private final boolean isBrowser;
    private final boolean isNative;

    public UserAgentProviderBase(String userAgentName, boolean isClient, boolean isBrowser, boolean isNative) {
        this.userAgentName = userAgentName;
        this.isClient = isClient;
        this.isBrowser = isBrowser;
        this.isNative = isNative;
    }

    @Override
    public String getUserAgentName() {
        return userAgentName;
    }

    @Override
    public boolean isClient() {
        return isClient;
    }

    @Override
    public boolean isBrowser() {
        return isBrowser;
    }

    @Override
    public boolean isNative() {
        return isNative;
    }
}
