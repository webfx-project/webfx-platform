package dev.webfx.platform.os;

import dev.webfx.platform.os.spi.OSProvider;
import dev.webfx.platform.util.serviceloader.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public final class OS {

    private static OSProvider getProvider() {
        return SingleServiceProvider.getProvider(OSProvider.class, () -> ServiceLoader.load(OSProvider.class));
    }

    public static OSFamily getOSFamily() {
        return getProvider().getOSFamily();
    }

    public static boolean isWindows() {
        return getOSFamily() == OSFamily.WINDOWS;
    }

    public static boolean isMacOS() {
        return getOSFamily() == OSFamily.MACOS;
    }

    public static boolean isLinux() {
        return getOSFamily() == OSFamily.LINUX;
    }

    public static boolean isAndroid() {
        return getOSFamily() == OSFamily.ANDROID;
    }

    public static boolean isIOS() {
        return getOSFamily() == OSFamily.IOS;
    }

    public static boolean isOther() {
        return getOSFamily() == OSFamily.OTHER;
    }

    public static boolean isDesktop() {
        switch (getOSFamily()) {
            case WINDOWS:
            case MACOS:
            case LINUX:
                return true;
            default: return false;
        }
    }

    public static boolean isMobile() {
        switch (getOSFamily()) {
            case ANDROID:
            case IOS:
                return true;
            default: return false;
        }
    }

}
