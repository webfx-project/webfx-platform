package dev.webfx.platform.visibility;

import dev.webfx.platform.visibility.spi.VisibilityProvider;
import dev.webfx.platform.service.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * The main entry point for the cross-platform Visibility API.
 * <p>
 * This class is inspired from the <a href="https://developer.mozilla.org/en-US/docs/Web/API/Page_Visibility_API">Page Visibility Web API</a>,
 * but extended to work on multiple platforms:
 * <ul>
 *   <li>Web - detecting when a browser tab gains or loses focus</li>
 *   <li>Desktop - detecting when an application window is minimized, restored, or becomes active/inactive</li>
 *   <li>Mobile - detecting when an app goes to the background or returns to the foreground</li>
 * </ul>
 *
 * This API allows applications to:
 * <ul>
 *   <li>Query the current visibility state of the application</li>
 *   <li>Register listeners to be notified when the visibility state changes</li>
 *   <li>Unregister previously registered listeners</li>
 * </ul>
 *
 * @author Bruno Salmon
 */
public class Visibility {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private Visibility() {}

    /**
     * Gets the visibility provider for the current platform.
     * 
     * @return the visibility provider implementation
     */
    private static VisibilityProvider getProvider() {
        return SingleServiceProvider.getProvider(VisibilityProvider.class, () -> ServiceLoader.load(VisibilityProvider.class));
    }

    /**
     * Gets the current visibility state of the application across any platform.
     * <p>
     * On web platforms, this corresponds to whether the browser tab is visible.
     * On desktop platforms, this corresponds to whether the application window is visible and not minimized.
     * On mobile platforms, this corresponds to whether the application is in the foreground.
     * 
     * @return the current visibility state (VISIBLE or HIDDEN)
     */
    public static VisibilityState getVisibilityState() {
        return getProvider().getVisibilityState();
    }

    /**
     * Registers a listener to be notified when the visibility state changes across any platform.
     * <p>
     * On web platforms, the listener will be notified when the browser tab visibility changes.
     * On desktop platforms, the listener will be notified when the application window visibility changes.
     * On mobile platforms, the listener will be notified when the application foreground/background state changes.
     * 
     * @param listener the listener to register
     */
    public static void addVisibilityListener(VisibilityListener listener) {
        getProvider().addVisibilityListener(listener);
    }

    /**
     * Unregisters a previously registered visibility listener across any platform.
     * 
     * This stops the listener from receiving notifications about visibility state changes
     * on web, desktop, or mobile platforms.
     * 
     * @param listener the listener to unregister
     */
    public static void removeVisibilityListener(VisibilityListener listener) {
        getProvider().removeVisibilityListener(listener);
    }

}
