package dev.webfx.platform.shutdown.spi.impl;

import dev.webfx.platform.shutdown.ShutdownEvent;
import dev.webfx.platform.shutdown.ShutdownEventOrigin;
import dev.webfx.platform.shutdown.ShutdownEventType;
import dev.webfx.platform.shutdown.spi.ShutdownProvider;
import dev.webfx.platform.util.collection.Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Bruno Salmon
 */
public abstract class ShutdownProviderBase implements ShutdownProvider {

    private final List<Consumer<ShutdownEvent>> hooks = new ArrayList<>();
    private boolean shuttingDown;

    @Override
    public boolean isShuttingDown() {
        return shuttingDown;
    }

    @Override
    public void addShutdownHook(Consumer<ShutdownEvent> hook) {
        hooks.add(hook);
    }

    @Override
    public void removeShutdownHook(Consumer<ShutdownEvent> hook) {
        hooks.remove(hook);
    }

    protected void fireShutdownEvent(ShutdownEvent event) {
        shuttingDown = event.getType() != ShutdownEventType.RESTORE;
        Collections.forEach(hooks, hook -> hook.accept(event));
    }

    public void exit(int exitStatus) {
        fireShutdownEvent(new ShutdownEvent(ShutdownEventType.EXIT, ShutdownEventOrigin.APPLICATION));
        finalExit(exitStatus);
    }

    protected abstract void finalExit(int exitStatus);

    @Override
    public void suspend() {
        fireShutdownEvent(new ShutdownEvent(ShutdownEventType.SUSPEND, ShutdownEventOrigin.APPLICATION));
    }
}
