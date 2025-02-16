package dev.webfx.platform.shutdown;

import dev.webfx.platform.service.SingleServiceProvider;
import dev.webfx.platform.shutdown.spi.ShutdownProvider;

import java.util.ServiceLoader;
import java.util.function.Consumer;

/**
 * @author Bruno Salmon
 */
public final class Shutdown {

    private Shutdown() {}

    private static ShutdownProvider getProvider() {
        return SingleServiceProvider.getProvider(ShutdownProvider.class, () -> ServiceLoader.load(ShutdownProvider.class));
    }

    /**
     * Adds a shutdown hook that will be called when the application is shutting down (unless the systems kills the
     * application process before). The shutdown may be originated by the user, the system, or requested by the
     * application itself (if the system allows it - @see canExit).
     *
     * @param hook
     */
    public static Consumer<ShutdownEvent> addShutdownHook(Consumer<ShutdownEvent> hook) {
        getProvider().addShutdownHook(hook);
        return hook;
    }

    /**
     * Removes a shutdown hook previously added through addShutdownHook().
     *
     * @param hook
     */
    public static void removeShutdownHook(Consumer<ShutdownEvent> hook) {
        getProvider().removeShutdownHook(hook);
    }

    /**
     * Indicates if the system allows the application to exit itself. In the browser and mobile apps, this may not be
     * allowed (only the user or system can close the application in that case).
     *
     * @return true if the system allows the application to exit itself.
     */
    public static boolean canExit() {
        return getProvider().canExit();
    }

    /**
     * Same as exit(0).
     */
    public static void exit() {
        exit(0);
    }

    /**
     * Requests the application to exit. This will first call all shutdown hooks, and then exit the application. However,
     * if the system doesn't allow the application to exit (canExit() returns false), the final exit won't happen, and
     * exit() will be the same as stop().
     *
     * @param exitStatus the exit status code passed to the system when finally exiting the application.
     */
    public static void exit(int exitStatus) {
        getProvider().exit(exitStatus);
    }

    public static boolean isShuttingDown() {
        return getProvider().isShuttingDown();
    }

    /**
     * Requests all shutdown hooks to be called, but doesn't ask the system to exit the application.
     */
    public static void suspend() {
        getProvider().suspend();
    }
}
