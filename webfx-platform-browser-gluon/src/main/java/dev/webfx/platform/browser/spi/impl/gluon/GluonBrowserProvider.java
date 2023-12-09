package dev.webfx.platform.browser.spi.impl.gluon;

import dev.webfx.platform.browser.spi.BrowserProvider;
import dev.webfx.platform.console.Console;
import dev.webfx.platform.uischeduler.UiScheduler;

/**
 * @author Bruno Salmon
 */
public class GluonBrowserProvider implements BrowserProvider {

    private com.gluonhq.attach.browser.BrowserService browserService;

    public GluonBrowserProvider() {
        // Note: All Gluon servies must be created in the UI thread, otherwise the application crashes
        UiScheduler.runInUiThread(() -> {
            browserService = com.gluonhq.attach.browser.BrowserService.create().orElse(null);
            if (browserService == null)
                Console.log("WARNING [WebFX Platform]: Unable to load Gluon Browser Service - external browser won't be able to be called");
        });
    }

    @Override
    public void launchExternalBrowser(String url) throws Exception {
        if (browserService != null)
            browserService.launchExternalBrowser(url);
    }
}
