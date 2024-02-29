package dev.webfx.platform.visibility.spi.impl.gwtj2cl;

import dev.webfx.platform.visibility.VisibilityState;
import dev.webfx.platform.visibility.spi.impl.VisibilityProviderBase;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public final class GwtJ2clVisibilityProvider extends VisibilityProviderBase {

    public GwtJ2clVisibilityProvider() {
        DomGlobal.document.addEventListener("visibilitychange", evt -> fireVisibilityChanged());
    }

    @Override
    public VisibilityState getVisibilityState() {
        return "visible".equals(DomGlobal.document.visibilityState) ? VisibilityState.VISIBLE : VisibilityState.HIDDEN;
    }

}
