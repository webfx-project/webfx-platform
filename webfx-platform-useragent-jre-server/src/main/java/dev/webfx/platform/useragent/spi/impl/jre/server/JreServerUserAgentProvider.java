package dev.webfx.platform.useragent.spi.impl.jre.server;

import dev.webfx.platform.useragent.spi.impl.ServerUserAgentProvider;

/**
 * @author Bruno Salmon
 */
public final class JreServerUserAgentProvider extends ServerUserAgentProvider {

    public JreServerUserAgentProvider() {
        super(System.getProperty("java.runtime.name"), false);
    }
}
