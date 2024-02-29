package dev.webfx.platform.browser.spi;

/**
 * @author Bruno Salmon
 */
public interface BrowserProvider {

    void launchExternalBrowser(String url) throws Exception;

}
