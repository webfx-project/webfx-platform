package dev.webfx.platform.browser.spi.impl.teavm;

import dev.webfx.platform.browser.spi.BrowserProvider;
import org.teavm.jso.browser.Window;

/**
 * @author Bruno Salmon
 */
public class TeaVmBrowserProvider implements BrowserProvider {

    @Override
    public void launchExternalBrowser(String url) {
        Window.current().open(url, null);
    }

}