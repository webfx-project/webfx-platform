package dev.webfx.platform.shutdown.spi.impl.teavm;

import dev.webfx.platform.shutdown.ShutdownEvent;
import dev.webfx.platform.shutdown.ShutdownEventOrigin;
import dev.webfx.platform.shutdown.ShutdownEventType;
import dev.webfx.platform.shutdown.spi.impl.ShutdownProviderBase;
import dev.webfx.platform.util.Booleans;
import dev.webfx.platform.util.teavm.TeaVmUtil;
import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.events.EventListener;

/**
 * @author Bruno Salmon
 */
public final class TeaVmShutdownProvider extends ShutdownProviderBase {

    public TeaVmShutdownProvider() {
        // Note: pagehide/pageshow are working on iOS Safari (but not "unload")
        EventListener<Event> pageHideOrUnloadListener = e -> {
            if (!isShuttingDown()) { // ensuring only one event is fired
                boolean persisted = e.getType().equals("pagehide") && Booleans.isTrue(TeaVmUtil.getJSBoolean(e, "persisted"));
                fireShutdownEvent(new ShutdownEvent(persisted ? ShutdownEventType.SUSPEND : ShutdownEventType.EXIT, ShutdownEventOrigin.USER_OR_SYSTEM));
            }
        };
        Window.current().addEventListener("pagehide", pageHideOrUnloadListener);
        Window.current().addEventListener("pageshow", e ->
            fireShutdownEvent(new ShutdownEvent(ShutdownEventType.RESTORE, ShutdownEventOrigin.USER_OR_SYSTEM)));
        // For old browsers that may not support pagehide/pageshow
        Window.current().addEventListener("beforeunload", pageHideOrUnloadListener);
        Window.current().addEventListener("unload", pageHideOrUnloadListener);
        // Note: browser event sequence = beforeunload → pagehide → unload
        // If the page is stored in Back/Forward Cache, only pagehide is fired with e.persisted = true
        // Otherwise, all 3 events are fired, but our listener will fire only 1 ShutdownEvent
    }

    @Override
    public boolean canExit() {
        // This is apparently the condition that browsers check to allow closing the window:
        return TeaVmUtil.getJSObject(Window.current(), "opener") != null || Window.current().getHistory().getLength() == 1;
    }

    @Override
    protected void finalExit(int exitStatus) { // exitStatus is ignored
        Window.current().close();
    }
}