package dev.webfx.platform.scheduler;

import dev.webfx.platform.scheduler.spi.SchedulerProvider;
import dev.webfx.platform.service.SingleServiceProvider;

import java.util.ServiceLoader;
import java.util.function.Consumer;

/**
 * @author Bruno Salmon
 */
public class Scheduler {

    protected Scheduler() {}

    public static SchedulerProvider getProvider() {
        return SingleServiceProvider.getProvider(SchedulerProvider.class, () -> ServiceLoader.load(SchedulerProvider.class));
    }

    /**
     * A deferred command is executed not now but as soon as possible (ex: after the event loop returns).
     */
    public static Scheduled scheduleDeferred(Runnable runnable) {
        return getProvider().scheduleDeferred(runnable);
    }

    /**
     * Set a one-shot timer to fire after {@code delayMs} milliseconds, at which point {@code handler}
     * will be called.
     *
     * @return the timer
     */
    public static Scheduled scheduleDelay(long delayMs, Runnable runnable) {
        return getProvider().scheduleDelay(delayMs, runnable);
    }

    /**
     * Schedules a repeating handler scheduled with constant periodicity. The handler will be invoked every
     * <code>delayMs</code> milliseconds, regardless of how long the previous invocation took to complete.
     *
     * @param delayMs the period with which the handler is executed
     * @param runnable the handler to execute
     * @return the timer
     */
    public static Scheduled schedulePeriodic(long delayMs, Runnable runnable) {
        return getProvider().schedulePeriodic(delayMs, runnable);
    }

    public static Scheduled schedulePeriodic(long delayMs, Consumer<Scheduled> runnable) {
        return getProvider().schedulePeriodic(delayMs, runnable);
    }

    public static Scheduled scheduleNowAndPeriodic(long delayMs, Runnable runnable) {
        Scheduled scheduled = schedulePeriodic(delayMs, runnable);
        runnable.run();
        return scheduled;
    }

    public static Scheduled scheduleNowAndPeriodic(long delayMs, Consumer<Scheduled> runnable) {
        Scheduled scheduled = schedulePeriodic(delayMs, runnable);
        runnable.accept(scheduled);
        return scheduled;
    }

    public static Scheduled runInBackground(Runnable runnable) {
        return getProvider().runInBackground(runnable);
    }

    public static Scheduled runOnIdle(Runnable runnable) {
        return getProvider().runOnIdle(runnable);
    }

    public static int tasksCount(boolean includeDeferred, boolean includePeriodic, boolean includeBackground, boolean includePending, boolean includeRunning) {
        return getProvider().tasksCount(includeDeferred, includePeriodic, includeBackground, includePending, includeRunning);
    }

    public static int tasksCount() {
        return tasksCount(true, true, true, true, true);
    }

    public static void wakeUp() {
        getProvider().wakeUp();
    }



    // The following methods are supposed to be used on the client-side only. They are actually implemented by
    // UiSchedulerProvider (which extends SchedulerProvider). The reason they are exposed here and not in UiScheduler
    // is to allow shared modules (usable by both client and server) to propose some client-specific features without
    // introducing a client dependency (to UiScheduler). This is in particular the case with the implementation of the
    // convenient Future.inUiThread() method, which is designed for client-side only, while all other Future methods are
    // designed for both client and server.


    private static SchedulerProvider uiSchedulerProvider; // Will be injected by UiSchedulerProviderBase constructor
    // using the setUiSchedulerProvider() method.

    public static void setUiSchedulerProvider(SchedulerProvider uiSchedulerProvider) {
        Scheduler.uiSchedulerProvider = uiSchedulerProvider;
    }

    public static boolean isUiThread() {
        return uiSchedulerProvider != null && uiSchedulerProvider.isUiThread();
    }

    public static void runInUiThread(Runnable runnable) {
        if (uiSchedulerProvider != null)
            uiSchedulerProvider.runInUiThread(runnable);
        else // May happen at the very beginning of the application, better to run it now
            runnable.run();
    }

    public static void runOutUiThread(Runnable runnable) {
        if (uiSchedulerProvider != null)
            uiSchedulerProvider.runOutUiThread(runnable);
        else // May happen at the very beginning of the application, better to run it now
            runnable.run();
    }

}
