package dev.webfx.platform.useragent.spi.impl.gwt;

import dev.webfx.platform.useragent.spi.impl.BrowserUserAgentProvider;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public final class GwtUserAgentProvider extends BrowserUserAgentProvider {

    public GwtUserAgentProvider() {
        super(DomGlobal.navigator.userAgent);
    }
}
