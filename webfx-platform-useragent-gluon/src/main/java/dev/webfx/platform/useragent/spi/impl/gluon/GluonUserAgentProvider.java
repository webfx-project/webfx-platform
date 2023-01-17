package dev.webfx.platform.useragent.spi.impl.gluon;

import dev.webfx.platform.useragent.spi.impl.ClientUserAgentProvider;
/**
 * @author Bruno Salmon
 */
public final class GluonUserAgentProvider extends ClientUserAgentProvider {

    public GluonUserAgentProvider() {
        super("Gluon", false, true);
    }

}

