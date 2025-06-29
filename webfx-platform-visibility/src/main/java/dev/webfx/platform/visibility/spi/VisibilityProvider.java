package dev.webfx.platform.visibility.spi;

import dev.webfx.platform.visibility.VisibilityListener;
import dev.webfx.platform.visibility.VisibilityState;

/**
 * Service Provider Interface (SPI) for the Visibility API.
 *
 * @author Bruno Salmon
 */
public interface VisibilityProvider {

    /**
     * Gets the current visibility state of the application.
     *
     * @return the current visibility state (VISIBLE or HIDDEN)
     */
    VisibilityState getVisibilityState();

    /**
     * Registers a listener to be notified when the visibility state changes.
     *
     * @param listener the listener to register
     */
    void addVisibilityListener(VisibilityListener listener);

    /**
     * Unregisters a previously registered visibility listener.
     *
     * @param listener the listener to unregister
     */
    void removeVisibilityListener(VisibilityListener listener);

}
