package dev.webfx.platform.browser.spi.impl.elemental2;

import dev.webfx.platform.browser.spi.BrowserProvider;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public class Elemental2BrowserProvider implements BrowserProvider {

    @Override
    public void launchExternalBrowser(String url) {
        DomGlobal.window.open(url);
    }

}
