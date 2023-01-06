package dev.webfx.platform.visibility.spi;

import dev.webfx.platform.visibility.VisibilityListener;
import dev.webfx.platform.visibility.VisibilityState;

public interface VisibilityProvider {

    VisibilityState getVisibilityState();

    void addVisibilityListener(VisibilityListener listener);

    void removeVisibilityListener(VisibilityListener listener);

}
