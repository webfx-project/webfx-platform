package dev.webfx.platform.useragent.spi.impl;

/**
 * @author Bruno Salmon
 */
public class ServerUserAgentProvider extends UserAgentProviderBase {

    public ServerUserAgentProvider(String userAgentName, boolean isNative) {
        super(userAgentName, false, false, isNative);
    }

}
