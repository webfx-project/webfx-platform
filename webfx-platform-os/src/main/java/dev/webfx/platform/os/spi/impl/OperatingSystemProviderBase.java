package dev.webfx.platform.os.spi.impl;

import dev.webfx.platform.os.OSFamily;
import dev.webfx.platform.os.spi.OperatingSystemProvider;

/**
 * @author Bruno Salmon
 */
public class OperatingSystemProviderBase implements OperatingSystemProvider {

    private final String osName;
    private final OSFamily osFamily;

    public OperatingSystemProviderBase(String osName) {
        this(osName, guessOSFamily(osName));
    }

    public OperatingSystemProviderBase(String osName, OSFamily osFamily) {
        this.osName = osName;
        this.osFamily = osFamily;
    }

    @Override
    public String getOSName() {
        return osName;
    }

    @Override
    public OSFamily getOSFamily() {
        return osFamily;
    }

    private static OSFamily guessOSFamily(String osName) {
        osName = osName.toLowerCase().replaceAll(" ", "");
        if (osName.contains("windows"))
            return OSFamily.WINDOWS;
        if (osName.contains("linux"))
            return OSFamily.LINUX;
        if (osName.contains("mac") || osName.contains("darwin"))
            return OSFamily.MACOS;
        if (osName.contains("android"))
            return OSFamily.ANDROID;
        if (osName.contains("ios"))
            return OSFamily.IOS;
        return OSFamily.OTHER;
    }
}
