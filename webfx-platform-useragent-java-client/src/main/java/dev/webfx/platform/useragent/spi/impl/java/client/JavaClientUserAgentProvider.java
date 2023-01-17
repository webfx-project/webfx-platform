package dev.webfx.platform.useragent.spi.impl.java.client;

import dev.webfx.platform.useragent.spi.impl.ClientUserAgentProvider;

/**
 * @author Bruno Salmon
 */
public final class JavaClientUserAgentProvider extends ClientUserAgentProvider {

    public JavaClientUserAgentProvider() {
        super(System.getProperty("java.runtime.name"), false, false);
    }
}
