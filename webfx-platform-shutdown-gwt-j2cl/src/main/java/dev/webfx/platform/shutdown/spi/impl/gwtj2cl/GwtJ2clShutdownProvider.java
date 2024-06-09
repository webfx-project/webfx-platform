package dev.webfx.platform.shutdown.spi.impl.gwtj2cl;

import dev.webfx.platform.shutdown.spi.impl.ShutdownProviderBase;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.EventListener;

/**
 * @author Bruno Salmon
 */
public final class GwtJ2clShutdownProvider extends ShutdownProviderBase<EventListener> {

    @Override
    protected EventListener createPlatformShutdownHook(Runnable hook) {
        return new EventListener() {
            boolean executed; // ensures it is executed only once if both beforeunload and unload are fired
            @Override
            public void handleEvent(Event evt) {
                if (!executed) {
                    executed = true;
                    hook.run();
                }
            }
        };
    }

    @Override
    protected void addPlatformShutdownHook(EventListener platformHook) {
        DomGlobal.window.addEventListener("beforeunload", platformHook);
        // Note: beforeunload doesn't work on iOS, so we use unload instead (deprecated but seems to work)
        DomGlobal.window.addEventListener("unload", platformHook);
    }

    @Override
    protected void removePlatformShutdownHook(EventListener platformHook) {
        DomGlobal.window.removeEventListener("beforeunload", platformHook);
        // Note: beforeunload doesn't work on iOS, so we use unload instead (deprecated but seems to work)
        DomGlobal.window.removeEventListener("unload", platformHook);
    }

    @Override
    public boolean canExit() {
        // This is apparently the condition that browsers check to allow closing the window:
        return DomGlobal.window.opener != null || DomGlobal.window.history.length == 1;
    }

    @Override
    protected void exit(int exitStatus) {
        DomGlobal.window.close();
    }
}
