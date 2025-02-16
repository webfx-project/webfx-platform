package dev.webfx.platform.shutdown.spi.impl.java;

import dev.webfx.platform.shutdown.ShutdownEvent;
import dev.webfx.platform.shutdown.ShutdownEventOrigin;
import dev.webfx.platform.shutdown.ShutdownEventType;
import dev.webfx.platform.shutdown.spi.impl.ShutdownProviderBase;

/**
 * @author Bruno Salmon
 */
public final class JavaShutdownProvider extends ShutdownProviderBase {

    private final Thread systemExitHook = new Thread(() -> fireShutdownEvent(new ShutdownEvent(ShutdownEventType.EXIT, ShutdownEventOrigin.SYSTEM)));

    public JavaShutdownProvider() {
        Runtime.getRuntime().addShutdownHook(systemExitHook);
    }

    @Override
    public boolean canExit() {
        return true;
    }

    @Override
    protected void finalExit(int exitStatus) {
        Runtime.getRuntime().removeShutdownHook(systemExitHook);
        System.exit(exitStatus);
    }
}
