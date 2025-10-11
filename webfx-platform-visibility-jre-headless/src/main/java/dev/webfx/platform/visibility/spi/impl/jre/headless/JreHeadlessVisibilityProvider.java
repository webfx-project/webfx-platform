package dev.webfx.platform.visibility.spi.impl.jre.headless;

import dev.webfx.platform.visibility.VisibilityState;
import dev.webfx.platform.visibility.spi.impl.VisibilityProviderBase;

/**
 * @author Bruno Salmon
 */
public final class JreHeadlessVisibilityProvider extends VisibilityProviderBase {

    private static VisibilityState VISIBILITY_STATE = VisibilityState.HIDDEN;
    private static JreHeadlessVisibilityProvider INSTANCE;

    public JreHeadlessVisibilityProvider() {
        INSTANCE = this;
    }

    @Override
    public VisibilityState getVisibilityState() {
        return VISIBILITY_STATE;
    }

    static void onStart() {
        VISIBILITY_STATE = VisibilityState.VISIBLE;
        if (INSTANCE != null)
            INSTANCE.fireVisibilityChanged();
    }

    static void onStop() {
        VISIBILITY_STATE = VisibilityState.HIDDEN;
        if (INSTANCE != null)
            INSTANCE.fireVisibilityChanged();
    }

}
