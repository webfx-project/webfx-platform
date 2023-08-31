package dev.webfx.platform.windowlocation.spi.impl.java;

import dev.webfx.platform.conf.ConfigLoader;
import dev.webfx.platform.windowlocation.spi.WindowLocationProvider;

/**
 * @author Bruno Salmon
 */
public final class JavaWindowLocationProvider implements WindowLocationProvider {

    // TODO: See how this class should interact with WindowHistory
    private String protocol;
    private String hostname;
    private String port;
    private String pathname;
    private String queryString;
    private String fragment;

    public JavaWindowLocationProvider() {
        ConfigLoader.onConfigLoaded("webfx.platform.windowlocation.java", config -> {
            protocol = config.getString("initialProtocol");
            hostname = config.getString("initialHostname");
            port = config.getString("initialPort");
            pathname = config.getString("initialPathname");
            queryString = config.getString("initialQueryString");
            fragment = config.getString("initialFragment");
        });
    }

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
