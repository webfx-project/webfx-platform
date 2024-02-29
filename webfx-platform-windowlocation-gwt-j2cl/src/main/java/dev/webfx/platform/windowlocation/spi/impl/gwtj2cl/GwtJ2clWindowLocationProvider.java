package dev.webfx.platform.windowlocation.spi.impl.gwtj2cl;

import dev.webfx.platform.util.Strings;
import dev.webfx.platform.windowlocation.spi.WindowLocationProvider;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public final class GwtJ2clWindowLocationProvider implements WindowLocationProvider {

    @Override
    public String getHref() {
        return DomGlobal.window.location.href;
    };

    @Override
    public String getProtocol() {
        return Strings.removeSuffix(getWindowProtocol(), ":");
    }

    private String getWindowProtocol() {
        return DomGlobal.window.location.protocol;
    };

    @Override
    public String getHost() {
        return DomGlobal.window.location.host;
    };

    @Override
    public String getHostname() {
        return DomGlobal.window.location.hostname;
    };

    @Override
    public String getPort() {
        return DomGlobal.window.location.port;
    };

    public String getPathname() {
        return DomGlobal.window.location.pathname;
    };

    @Override
    public String getSearch() {
        return DomGlobal.window.location.search;
    };

    @Override
    public String getQueryString() {
        return Strings.removePrefix(getSearch(), "?");
    }

    @Override
    public String getHash() {
        return DomGlobal.window.location.hash;
    };

    @Override
    public String getFragment() {
        return Strings.removePrefix(getHash(), "#");
    }

    @Override
    public void assignHref(String href) {
        DomGlobal.window.location.assign(href);
    };

    @Override
    public void replaceHref(String href) {
        DomGlobal.window.location.replace(href);
    };
}
