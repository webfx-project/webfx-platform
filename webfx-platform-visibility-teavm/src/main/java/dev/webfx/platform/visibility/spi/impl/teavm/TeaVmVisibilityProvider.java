package dev.webfx.platform.visibility.spi.impl.teavm;

import dev.webfx.platform.util.teavm.TeaVmUtil;
import dev.webfx.platform.visibility.VisibilityState;
import dev.webfx.platform.visibility.spi.impl.VisibilityProviderBase;
import org.teavm.jso.browser.Window;

/**
 * @author Bruno Salmon
 */
public final class TeaVmVisibilityProvider extends VisibilityProviderBase {

    public TeaVmVisibilityProvider() {
        Window.current().getDocument().addEventListener("visibilitychange", evt -> fireVisibilityChanged());
    }

    @Override
    public VisibilityState getVisibilityState() {
        return "visible".equals(TeaVmUtil.getJSString(Window.current().getDocument(), "visibilityState")) ? VisibilityState.VISIBLE : VisibilityState.HIDDEN;
    }

}