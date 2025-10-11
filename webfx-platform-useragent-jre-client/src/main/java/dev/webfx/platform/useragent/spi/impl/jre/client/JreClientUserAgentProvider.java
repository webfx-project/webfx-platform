package dev.webfx.platform.useragent.spi.impl.jre.client;

import dev.webfx.platform.useragent.spi.impl.ClientUserAgentProvider;

/**
 * @author Bruno Salmon
 */
public final class JreClientUserAgentProvider extends ClientUserAgentProvider {

    public JreClientUserAgentProvider() {
        super(System.getProperty("java.runtime.name"), false, false);
    }
}
