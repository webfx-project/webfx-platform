package dev.webfx.platform.visibility.spi.impl.java.headless;

import dev.webfx.platform.visibility.VisibilityState;
import dev.webfx.platform.visibility.spi.impl.VisibilityProviderBase;

/**
 * @author Bruno Salmon
 */
public final class JavaHeadlessVisibilityProvider extends VisibilityProviderBase {

    private static VisibilityState VISIBILITY_STATE = VisibilityState.HIDDEN;
    private static JavaHeadlessVisibilityProvider INSTANCE;

    public JavaHeadlessVisibilityProvider() {
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
