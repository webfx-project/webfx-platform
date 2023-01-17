package dev.webfx.platform.os.spi.impl.java;

import dev.webfx.platform.os.spi.impl.OSProviderBase;

/**
 * @author Bruno Salmon
 */
public final class JavaOSProvider extends OSProviderBase {

    public JavaOSProvider() {
        super(System.getProperty("os.name"));
    }
}
