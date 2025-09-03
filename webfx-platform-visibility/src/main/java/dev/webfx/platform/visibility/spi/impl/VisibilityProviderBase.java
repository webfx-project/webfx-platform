package dev.webfx.platform.visibility.spi.impl;

import dev.webfx.platform.visibility.VisibilityListener;
import dev.webfx.platform.visibility.VisibilityState;
import dev.webfx.platform.visibility.spi.VisibilityProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base implementation of the {@link VisibilityProvider} interface.
 * <p>
 * This class provides common functionality for platform-specific visibility providers, including
 * management of visibility listeners and notification of visibility state changes.
 * <p>
 * Concrete subclasses need to implement the {@link #getVisibilityState()} method
 * and call {@link #fireVisibilityChanged()} when the visibility state changes, according
 * to platform-specific detection mechanisms.
 *
 * @author Bruno Salmon
 */
public abstract class VisibilityProviderBase implements VisibilityProvider {

    /**
     * List of registered visibility listeners that will be notified of visibility state changes.
     * This is used across all platforms (web, desktop, mobile) to track interested listeners.
     */
    private final List<VisibilityListener> listeners = new ArrayList<>();

    /**
     * {@inheritDoc}
     * Adds a visibility listener to the list of registered listeners.
     */
    @Override
    public void addVisibilityListener(VisibilityListener listener) {
        listeners.add(listener);
    }

    /**
     * {@inheritDoc}
     * Removes a visibility listener from the list of registered listeners.
     */
    @Override
    public void removeVisibilityListener(VisibilityListener listener) {
        listeners.remove(listener);
    }

    /**
     * Notifies all registered listeners about a visibility state change.
     * This method should be called by platform-specific implementations when they detect
     * a change in visibility state (e.g., browser tab visibility change, window minimization,
     * or mobile app going to the background).
     */
    protected void fireVisibilityChanged() {
        VisibilityState visibleState = getVisibilityState();
        listeners.forEach(l -> l.onVisibilityStateChanged(visibleState));
    }

}
