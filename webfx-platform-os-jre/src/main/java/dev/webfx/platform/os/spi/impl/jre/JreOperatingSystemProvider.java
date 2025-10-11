package dev.webfx.platform.os.spi.impl.jre;

import dev.webfx.platform.os.spi.impl.OperatingSystemProviderBase;

/**
 * @author Bruno Salmon
 */
public final class JreOperatingSystemProvider extends OperatingSystemProviderBase {

    public JreOperatingSystemProvider() {
        super(System.getProperty("os.name"));
    }
}
