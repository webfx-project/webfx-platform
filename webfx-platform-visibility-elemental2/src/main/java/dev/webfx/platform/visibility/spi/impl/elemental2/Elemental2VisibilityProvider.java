package dev.webfx.platform.visibility.spi.impl.elemental2;

import dev.webfx.platform.visibility.VisibilityState;
import dev.webfx.platform.visibility.spi.impl.VisibilityProviderBase;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public final class Elemental2VisibilityProvider extends VisibilityProviderBase {

    public Elemental2VisibilityProvider() {
        DomGlobal.document.addEventListener("visibilitychange", evt -> fireVisibilityChanged());
    }

    @Override
    public VisibilityState getVisibilityState() {
        return "visible".equals(DomGlobal.document.visibilityState) ? VisibilityState.VISIBLE : VisibilityState.HIDDEN;
    }

    @Override
    protected void fireVisibilityChanged() {
        super.fireVisibilityChanged();
    }
}
