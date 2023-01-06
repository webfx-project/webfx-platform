package dev.webfx.platform.visibility.spi.impl.gwt;

import dev.webfx.platform.visibility.VisibilityState;
import dev.webfx.platform.visibility.spi.impl.VisibilityProviderBase;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public final class GwtVisibilityProvider extends VisibilityProviderBase {

    public GwtVisibilityProvider() {
        DomGlobal.document.addEventListener("visibilitychange", evt -> fireVisibilityChanged());
    }

    @Override
    public VisibilityState getVisibilityState() {
        return "visible".equals(DomGlobal.document.visibilityState) ? VisibilityState.VISIBLE : VisibilityState.HIDDEN;
    }

}
