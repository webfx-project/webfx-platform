package dev.webfx.platform.shutdown;

import dev.webfx.platform.shutdown.spi.ShutdownProvider;
import dev.webfx.platform.service.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public final class Shutdown {

    private Shutdown() {}

    private static ShutdownProvider getProvider() {
        return SingleServiceProvider.getProvider(ShutdownProvider.class, () -> ServiceLoader.load(ShutdownProvider.class));
    }

    public static void addShutdownHook(Runnable hook) {
        getProvider().addShutdownHook(hook);
    }

    public static void removeShutdownHook(Runnable hook) {
        getProvider().removeShutdownHook(hook);
    }

    public static boolean canExit() {
        return getProvider().canExit();
    }

    public static void softwareShutdown(boolean exit, int exitStatus) {
        getProvider().softwareShutdown(exit, exitStatus);
    }

    public static boolean isShuttingDown() {
        return getProvider().isShuttingDown();
    }

    public static boolean isSoftwareShutdown() {
        return getProvider().isSoftwareShutdown();
    }
}
