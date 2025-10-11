package dev.webfx.platform.useragent.spi.impl.java.server;

import dev.webfx.platform.useragent.spi.impl.ServerUserAgentProvider;

/**
 * @author Bruno Salmon
 */
public final class JavaServerUserAgentProvider extends ServerUserAgentProvider {

    public JavaServerUserAgentProvider() {
        super(System.getProperty("java.runtime.name"), false);
    }
}
