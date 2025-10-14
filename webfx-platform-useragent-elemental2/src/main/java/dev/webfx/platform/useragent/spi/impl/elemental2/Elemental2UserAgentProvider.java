package dev.webfx.platform.useragent.spi.impl.elemental2;

import dev.webfx.platform.useragent.spi.impl.BrowserUserAgentProvider;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public final class Elemental2UserAgentProvider extends BrowserUserAgentProvider {

    public Elemental2UserAgentProvider() {
        super(DomGlobal.navigator.userAgent);
    }
}
