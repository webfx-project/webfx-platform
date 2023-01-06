package dev.webfx.platform.visibility.spi.impl;

import dev.webfx.platform.visibility.VisibilityListener;
import dev.webfx.platform.visibility.VisibilityState;
import dev.webfx.platform.visibility.spi.VisibilityProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Salmon
 */
public abstract class VisibilityProviderBase implements VisibilityProvider {

    private final List<VisibilityListener> listeners = new ArrayList<>();

    @Override
    public void addVisibilityListener(VisibilityListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeVisibilityListener(VisibilityListener listener) {
        listeners.remove(listener);
    }

    protected void fireVisibilityChanged() {
        VisibilityState visibleState = getVisibilityState();
        listeners.forEach(l -> l.onVisibilityStateChanged(visibleState));
    }

}
