package dev.webfx.platform.shutdown.spi.impl.gwtj2cl;

import dev.webfx.platform.shutdown.spi.impl.ShutdownProviderBase;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.EventListener;

/**
 * @author Bruno Salmon
 */
public final class GwtJ2clShutdownProvider extends ShutdownProviderBase<EventListener> {

    private static final String[] SHUTDOWN_EVENTS = {
        "beforeunload", // not working on iOS
        "unload", // not working on iOS
        "pagehide" // working on iOS. But page may be stored in bfcache and restored later, so may be not a final shutdown...
    };

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
        for (String event : SHUTDOWN_EVENTS)
            DomGlobal.window.addEventListener(event, platformHook);
    }

    @Override
    protected void removePlatformShutdownHook(EventListener platformHook) {
        for (String event : SHUTDOWN_EVENTS)
            DomGlobal.window.removeEventListener(event, platformHook);
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
