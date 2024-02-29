package dev.webfx.platform.useragent.spi.impl.gwtj2cl;

import dev.webfx.platform.useragent.spi.impl.BrowserUserAgentProvider;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public final class GwtJ2clUserAgentProvider extends BrowserUserAgentProvider {

    public GwtJ2clUserAgentProvider() {
        super(DomGlobal.navigator.userAgent);
    }
}
