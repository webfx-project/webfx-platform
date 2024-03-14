package dev.webfx.platform.windowlocation.spi.impl.java;

import dev.webfx.platform.conf.zero.ZeroConfig;
import dev.webfx.platform.windowlocation.spi.WindowLocationProvider;

/**
 * @author Bruno Salmon
 */
public final class JavaWindowLocationProvider implements WindowLocationProvider {

    // TODO: See how this class should interact with JavaWindowHistoryProvider

    private final static String CONFIG_PATH = "webfx.platform.windowlocation.java";
    private String protocol = ZeroConfig.lookupString(CONFIG_PATH, "initialProtocol");
    private String hostname = ZeroConfig.lookupString(CONFIG_PATH, "initialHostname", "localhost");
    private String port = ZeroConfig.lookupString(CONFIG_PATH, "initialPort", "80");
    private String pathname = ZeroConfig.lookupString(CONFIG_PATH, "initialPathname", "/");
    private String queryString = ZeroConfig.lookupString(CONFIG_PATH, "initialQueryString");
    private String fragment = ZeroConfig.lookupString(CONFIG_PATH, "initialFragment");

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
        return pathname;
    }

    @Override
    public String getQueryString() {
        return queryString;
    }

    @Override
    public String getFragment() {
        return fragment;
    }

    @Override
    public void assignHref(String href) {
        // TODO: recompute the fields from href
    }

    @Override
    public void replaceHref(String href) {
        assignHref(href);
    }
}
