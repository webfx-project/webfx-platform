package dev.webfx.platform.browser.spi.impl.gwt;

import dev.webfx.platform.browser.spi.BrowserProvider;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public class GwtBrowserProvider implements BrowserProvider {

    @Override
    public void launchExternalBrowser(String url) {
        DomGlobal.window.open(url);
    }

}
