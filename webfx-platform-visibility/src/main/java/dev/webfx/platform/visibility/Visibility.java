package dev.webfx.platform.visibility;

import dev.webfx.platform.visibility.spi.VisibilityProvider;
import dev.webfx.platform.util.serviceloader.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public class Visibility {

    private static VisibilityProvider getProvider() {
        return SingleServiceProvider.getProvider(VisibilityProvider.class, () -> ServiceLoader.load(VisibilityProvider.class));
    }

    public static VisibilityState getVisiblityState() {
        return getProvider().getVisibilityState();
    }

    public static void addVisibilityListener(VisibilityListener listener) {
        getProvider().addVisibilityListener(listener);
    }

    public static void removeVisibilityListener(VisibilityListener listener) {
        getProvider().removeVisibilityListener(listener);
    }

}
