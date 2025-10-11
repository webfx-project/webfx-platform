package dev.webfx.platform.windowlocation.spi.impl.jre;

import dev.webfx.platform.conf.zero.ZeroConfig;
import dev.webfx.platform.windowhistory.WindowHistory;
import dev.webfx.platform.windowhistory.spi.BrowsingHistoryLocation;
import dev.webfx.platform.windowlocation.spi.WindowLocationProvider;
import dev.webfx.platform.windowlocation.spi.impl.BrowsingLocationImpl;

/**
 * @author Bruno Salmon
 */
public final class JreWindowLocationProvider implements WindowLocationProvider {

    private final static String CONFIG_PATH = "webfx.platform.windowlocation.jre";
    private String protocol = ZeroConfig.lookupString(CONFIG_PATH, "initialProtocol");
    private String hostname = ZeroConfig.lookupString(CONFIG_PATH, "initialHostname", "localhost");
    private String port = ZeroConfig.lookupString(CONFIG_PATH, "initialPort", "80");

    @Override
    public String getProtocol() {
        return protocol;
    }

    @Override
    public String getHostname() {
        return hostname;
    }

    @Override
    public String getPort() {
        return port;
    }

    @Override
    public String getPathname() {
        BrowsingHistoryLocation currentLocation = WindowHistory.getCurrentLocation();
        String pathname = currentLocation != null ? currentLocation.getPathname() : null;
        if (pathname != null && !pathname.contains("/#"))
            pathname = "/#" + pathname;
        return pathname;
    }

    @Override
    public String getQueryString() {
        BrowsingHistoryLocation currentLocation = WindowHistory.getCurrentLocation();
        return currentLocation != null ? currentLocation.getQueryString() : null;
    }

    @Override
    public String getFragment() {
        BrowsingHistoryLocation currentLocation = WindowHistory.getCurrentLocation();
        return currentLocation != null ? currentLocation.getFragment() : null;
    }

    @Override
    public void assignHref(String href) {
        changeHref(href, false);
    }

    @Override
    public void replaceHref(String href) {
        changeHref(href, true);
    }

    private void changeHref(String href, boolean replace) {
        BrowsingLocationImpl browsingLocation = BrowsingLocationImpl.fromHref(href);
        protocol = browsingLocation.getProtocol();
        hostname = browsingLocation.getHostname();
        port = browsingLocation.getPort();
        if (replace)
            WindowHistory.getProvider().replace(browsingLocation.getPath());
        else
            WindowHistory.getProvider().push(browsingLocation.getPath());
    }
}
