package dev.webfx.platform.scheduler;

/**
 * @author Bruno Salmon
 */
public interface Cancellable {

    /**
     * Cancel the scheduled task. Returns {@code} true if the task was successfully cancelled.
     */
    boolean cancel();

}
