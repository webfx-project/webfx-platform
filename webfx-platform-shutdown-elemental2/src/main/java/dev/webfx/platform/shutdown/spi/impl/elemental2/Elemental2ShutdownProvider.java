package dev.webfx.platform.shutdown.spi.impl.elemental2;

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
public final class Elemental2ShutdownProvider extends ShutdownProviderBase {

    public Elemental2ShutdownProvider() {
        // Note: pagehide/pageshow are working on iOS Safari (but not "unload")
        EventListener pageHideOrUnloadListener = e -> {
            if (!isShuttingDown()) { // ensuring only one event is fired
                boolean persisted = e instanceof PageTransitionEvent pageTransitionEvent && pageTransitionEvent.persisted;
                fireShutdownEvent(new ShutdownEvent(persisted ? ShutdownEventType.SUSPEND : ShutdownEventType.EXIT, ShutdownEventOrigin.USER_OR_SYSTEM));
            }
        };
        DomGlobal.window.addEventListener("pagehide", pageHideOrUnloadListener);
        DomGlobal.window.addEventListener("pageshow", e ->
            fireShutdownEvent(new ShutdownEvent(ShutdownEventType.RESTORE, ShutdownEventOrigin.USER_OR_SYSTEM)));
        // For old browsers that may not support pagehide/pageshow
        DomGlobal.window.addEventListener("beforeunload", pageHideOrUnloadListener);
        DomGlobal.window.addEventListener("unload", pageHideOrUnloadListener);
        // Note: the browser event sequence = beforeunload → pagehide → unload
        // If the page is stored in Back/Forward Cache, only pagehide is fired with e.persisted = true
        // Otherwise, all 3 events are fired, but our listener will fire only 1 ShutdownEvent
    }

    @Override
    public boolean isShuttingDown() {
        return super.isShuttingDown();
    }

    @Override
    protected void fireShutdownEvent(ShutdownEvent event) {
        super.fireShutdownEvent(event);
    }

    @Override
    public boolean canExit() {
        // This is apparently the condition that browsers check to allow closing the window:
        // boolean canExit = DomGlobal.window.opener != null || DomGlobal.window.history.length == 1;
        // Rewrote the above code for compatibility with TeaVM elemental2 polyfill:
        return DomGlobal.window.opener != null || DomGlobal.window.history.length == 1;
    }

    @Override
    protected void finalExit(int exitStatus) { // exitStatus is ignored
        DomGlobal.window.close();
    }
}
