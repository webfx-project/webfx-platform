package dev.webfx.platform.useragent.spi.impl;

/**
 * @author Bruno Salmon
 */
public class ClientUserAgentProvider extends UserAgentProviderBase {

    public ClientUserAgentProvider(String userAgentName, boolean isBrowser, boolean isNative) {
        super(userAgentName, true, isBrowser, isNative);
    }
}
