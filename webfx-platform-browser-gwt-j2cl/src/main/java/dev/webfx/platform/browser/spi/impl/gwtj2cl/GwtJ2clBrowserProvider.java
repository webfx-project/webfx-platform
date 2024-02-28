package dev.webfx.platform.browser.spi.impl.gwtj2cl;

import dev.webfx.platform.browser.spi.BrowserProvider;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public class GwtJ2clBrowserProvider implements BrowserProvider {

    @Override
    public void launchExternalBrowser(String url) {
        DomGlobal.window.open(url);
    }

}
