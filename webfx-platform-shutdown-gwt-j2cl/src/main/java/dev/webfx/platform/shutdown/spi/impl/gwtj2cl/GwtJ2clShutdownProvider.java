package dev.webfx.platform.shutdown.spi.impl.gwtj2cl;

import dev.webfx.platform.shutdown.ShutdownEvent;
import dev.webfx.platform.shutdown.ShutdownEventOrigin;
import dev.webfx.platform.shutdown.ShutdownEventType;
import dev.webfx.platform.shutdown.spi.impl.ShutdownProviderBase;
import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.PageTransitionEvent;

/**
 * @author Bruno Salmon
 */
public final class GwtJ2clShutdownProvider extends ShutdownProviderBase {

    public GwtJ2clShutdownProvider() {
        // Note: pagehide/pageshow are working on iOS Safari (but not "unload")
        EventListener pageHideOrUnloadListener = e -> {
            if (!isShuttingDown()) { // ensuring only one event is fired
                boolean persisted = e instanceof PageTransitionEvent && ((PageTransitionEvent) e).persisted;
                fireShutdownEvent(new ShutdownEvent(persisted ? ShutdownEventType.SUSPEND : ShutdownEventType.EXIT, ShutdownEventOrigin.USER_OR_SYSTEM));
            }
        };
        DomGlobal.window.addEventListener("pagehide", pageHideOrUnloadListener);
        DomGlobal.window.addEventListener("pageshow", e ->
            fireShutdownEvent(new ShutdownEvent(ShutdownEventType.RESTORE, ShutdownEventOrigin.USER_OR_SYSTEM)));
        // For old browsers that may not support pagehide/pageshow
        DomGlobal.window.addEventListener("beforeunload", pageHideOrUnloadListener);
        DomGlobal.window.addEventListener("unload", pageHideOrUnloadListener);
        // Note: browser event sequence = beforeunload → pagehide → unload
        // If the page is stored in Back/Forward Cache, only pagehide is fired with e.persisted = true
        // Otherwise, all 3 events are fired, but our listener will fire only 1 ShutdownEvent
    }

    @Override
    public boolean canExit() {
        // This is apparently the condition that browsers check to allow closing the window:
        return DomGlobal.window.opener != null || DomGlobal.window.history.length == 1;
    }

    @Override
    protected void finalExit(int exitStatus) { // exitStatus is ignored
        DomGlobal.window.close();
    }
}
