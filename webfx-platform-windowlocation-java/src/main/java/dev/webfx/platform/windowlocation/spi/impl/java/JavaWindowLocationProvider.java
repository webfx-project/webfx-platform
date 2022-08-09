package dev.webfx.platform.windowlocation.spi.impl.java;

import dev.webfx.platform.windowhistory.WindowHistory;
import dev.webfx.platform.windowlocation.spi.HostLocation;
import dev.webfx.platform.windowlocation.spi.WindowLocationProvider;
import dev.webfx.platform.windowlocation.spi.impl.BrowsingLocationImpl;

/**
 * @author Bruno Salmon
 */
public final class JavaWindowLocationProvider extends BrowsingLocationImpl implements WindowLocationProvider {

    // Should be set before using this provider
    private static HostLocation HOST_LOCATION;

    public JavaWindowLocationProvider() {
        super(HOST_LOCATION.getProtocol(), HOST_LOCATION.getHostname(), HOST_LOCATION.getPort(), WindowHistory.getCurrentLocation());
    }

    // Should be called before using this provider (see JavaWebsocketBusServiceProvider)
    public static void setHostLocation(HostLocation hostLocation) {
        HOST_LOCATION = hostLocation;
    }
}
