package dev.webfx.platform.shutdown.spi.impl.gwt;

import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import dev.webfx.platform.shutdown.spi.impl.ShutdownProviderBase;

/**
 * @author Bruno Salmon
 */
public final class GwtShutdownProvider extends ShutdownProviderBase<EventListener> {

    @Override
    protected EventListener createPlatformShutdownHook(Runnable hook) {
        return evt -> hook.run();
    }

    @Override
    protected void addPlatformShutdownHook(EventListener platformHook) {
        DomGlobal.window.addEventListener("beforeunload", platformHook);
    }

    @Override
    protected void removePlatformShutdownHook(EventListener platformHook) {
        DomGlobal.window.removeEventListener("beforeunload", platformHook);
    }

    @Override
    public boolean supportsExit() {
        // This is apparently the condition that browsers check to allow closing the window:
        return DomGlobal.window.opener != null || DomGlobal.window.history.length == 1;
    }

    @Override
    protected void exit(int exitStatus) {
        DomGlobal.window.close();
    }
}
