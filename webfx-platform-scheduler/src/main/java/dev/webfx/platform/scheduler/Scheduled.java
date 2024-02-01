package dev.webfx.platform.scheduler;

/**
 * @author Bruno Salmon
 */
public interface Scheduled extends Cancellable {

    boolean isDeferred();

    boolean isPeriodic();

    boolean isBackground();

    boolean isIdle();

    boolean isStarted();

    boolean isFinished();

    boolean isPending();

    boolean isRunning();

    boolean isCancelled();

}
