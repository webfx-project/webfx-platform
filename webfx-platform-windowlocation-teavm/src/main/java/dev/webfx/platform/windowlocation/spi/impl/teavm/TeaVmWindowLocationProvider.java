package dev.webfx.platform.windowlocation.spi.impl.teavm;

import dev.webfx.platform.util.Strings;
import dev.webfx.platform.windowlocation.spi.WindowLocationProvider;
import org.teavm.jso.browser.Location;
import org.teavm.jso.browser.Window;

/**
 * @author Bruno Salmon
 */
public final class TeaVmWindowLocationProvider implements WindowLocationProvider {

    private static Location getCurrentLocation() {
        return Window.current().getLocation();
    }

    @Override
    public String getHref() {
        return getCurrentLocation().getFullURL();
    }

    @Override
    public String getProtocol() {
        return Strings.removeSuffix(getWindowProtocol(), ":");
    }

    private String getWindowProtocol() {
        return getCurrentLocation().getProtocol();
    }

    @Override
    public String getHost() {
        return getCurrentLocation().getHost();
    }

    @Override
    public String getHostname() {
        return getCurrentLocation().getHostName();
    }

    @Override
    public String getPort() {
        return getCurrentLocation().getPort();
    }

    public String getPathname() {
        return getCurrentLocation().getPathName();
    }

    @Override
    public String getSearch() {
        return getCurrentLocation().getSearch();
    };

    @Override
    public String getQueryString() {
        return Strings.removePrefix(getSearch(), "?");
    }

    @Override
    public String getHash() {
        return getCurrentLocation().getHash();
    };

    @Override
    public String getFragment() {
        return Strings.removePrefix(getHash(), "#");
    }

    @Override
    public void assignHref(String href) {
        getCurrentLocation().assign(href);
    };

    @Override
    public void replaceHref(String href) {
        getCurrentLocation().replace(href);
    };
}