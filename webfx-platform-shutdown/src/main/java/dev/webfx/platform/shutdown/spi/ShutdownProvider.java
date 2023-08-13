package dev.webfx.platform.shutdown.spi;

/**
 * @author Bruno Salmon
 */
public interface ShutdownProvider {

    void addShutdownHook(Runnable hook);

    void removeShutdownHook(Runnable hook);

    void softwareShutdown(boolean exit, int exitStatus);

    boolean canExit();

    boolean isShuttingDown();

    boolean isSoftwareShutdown();

}
