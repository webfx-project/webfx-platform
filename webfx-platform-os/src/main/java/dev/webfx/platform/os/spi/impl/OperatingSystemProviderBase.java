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
        this(osName, -1);
    }

    public OperatingSystemProviderBase(String osName, int maxTouchPoints) {
        this(osName, guessOSFamily(osName, maxTouchPoints));
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

    private static OSFamily guessOSFamily(String osName, int maxTouchPoints) {
        osName = osName.toLowerCase().replaceAll(" ", "");
        if (osName.contains("android"))
            return OSFamily.ANDROID;
        if (osName.contains("ios") || osName.contains("iphone") || osName.contains("ipad"))
            return OSFamily.IOS;
        if (osName.contains("windows"))
            return OSFamily.WINDOWS;
        if (osName.contains("mac") || osName.contains("darwin"))
            // Using maxTouchPoints to detect iPadOS masquerading as macOS (iPadOS 13+)
            return maxTouchPoints > 0 ? OSFamily.IOS : OSFamily.MACOS;
        if (osName.contains("linux"))
            return OSFamily.LINUX;
        return OSFamily.OTHER;
    }
}
