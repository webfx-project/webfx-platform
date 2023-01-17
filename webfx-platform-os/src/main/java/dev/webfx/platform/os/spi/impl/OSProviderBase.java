package dev.webfx.platform.os.spi.impl;

import dev.webfx.platform.os.OSFamily;
import dev.webfx.platform.os.spi.OSProvider;

/**
 * @author Bruno Salmon
 */
public class OSProviderBase implements OSProvider {

    private final OSFamily osFamily;

    public OSProviderBase(String textContainingOSName) {
        this(parseOSFamily(textContainingOSName));
    }

    public OSProviderBase(OSFamily osFamily) {
        this.osFamily = osFamily;
    }

    @Override
    public OSFamily getOSFamily() {
        return osFamily;
    }

    private static OSFamily parseOSFamily(String osName) {
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
