package dev.webfx.platform.os.spi.impl.java;

import dev.webfx.platform.os.spi.impl.OperatingSystemProviderBase;

/**
 * @author Bruno Salmon
 */
public final class JavaOperatingSystemProvider extends OperatingSystemProviderBase {

    public JavaOperatingSystemProvider() {
        super(System.getProperty("os.name"));
    }
}
