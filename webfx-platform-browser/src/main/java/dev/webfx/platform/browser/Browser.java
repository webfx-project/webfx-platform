package dev.webfx.platform.browser;

import dev.webfx.platform.browser.spi.BrowserProvider;
import dev.webfx.platform.service.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public final class Browser {

    private Browser() { }

    private static BrowserProvider getProvider() {
        return SingleServiceProvider.getProvider(BrowserProvider.class, () -> ServiceLoader.load(BrowserProvider.class));
    }

    public static void launchExternalBrowser(String url) throws Exception {
        getProvider().launchExternalBrowser(url);
    }

}
