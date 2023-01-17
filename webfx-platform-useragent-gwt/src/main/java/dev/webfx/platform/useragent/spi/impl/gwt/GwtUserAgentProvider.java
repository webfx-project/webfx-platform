package dev.webfx.platform.useragent.spi.impl.gwt;

import dev.webfx.platform.useragent.spi.impl.ClientUserAgentProvider;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public final class GwtUserAgentProvider extends ClientUserAgentProvider {

    public GwtUserAgentProvider() {
        super(DomGlobal.navigator.userAgent, true, false);
    }
}
