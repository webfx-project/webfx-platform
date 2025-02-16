package dev.webfx.platform.shutdown.spi;

import dev.webfx.platform.shutdown.ShutdownEvent;

import java.util.function.Consumer;

/**
 * @author Bruno Salmon
 */
public interface ShutdownProvider {

    void addShutdownHook(Consumer<ShutdownEvent> hook);

    void removeShutdownHook(Consumer<ShutdownEvent> hook);

    boolean canExit();

    boolean isShuttingDown();

    void exit(int exitStatus);

    void suspend();

}
