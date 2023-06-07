package dev.webfx.platform.scheduler.spi;

import dev.webfx.platform.console.Console;
import dev.webfx.platform.scheduler.Scheduled;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Bruno Salmon
 */
public abstract class SchedulerProviderBase implements SchedulerProvider {

    private final AtomicInteger pendingDeferredCount = new AtomicInteger();
    private final AtomicInteger runningDeferredCount = new AtomicInteger();
    private final AtomicInteger pendingPeriodicCount = new AtomicInteger();
    private final AtomicInteger runningPeriodicCount = new AtomicInteger();
    private final AtomicInteger pendingBackgroundCount = new AtomicInteger();
    private final AtomicInteger runningBackgroundCount = new AtomicInteger();

    @Override
    public Scheduled scheduleDeferred(Runnable runnable) {
        return scheduleImpl(runnable, 0, true, false, false);
    }

    @Override
    public Scheduled scheduleDelay(long delayMs, Runnable runnable) {
        return scheduleImpl(runnable, delayMs, true, false, false);
    }

    @Override
    public Scheduled schedulePeriodic(long delayMs, Runnable runnable) {
        return scheduleImpl(runnable, delayMs, false, true, false);
    }
    
    @Override
    public Scheduled runInBackground(Runnable runnable) {
        return scheduleImpl(runnable, 0, false, false, true);
    }

    protected Scheduled scheduleImpl(Runnable runnable, long delayMs, boolean deferred, boolean periodic, boolean background) {
        return scheduledImpl(new WrappedRunnable(runnable, deferred, periodic, background), delayMs);
    }

    protected abstract ScheduledBase scheduledImpl(WrappedRunnable wrappedRunnable, long delayMs);

    public int tasksCount(boolean deferred, boolean periodic, boolean background, boolean pending, boolean running) {
        int count = 0;
        if (pending) {
            if (deferred)
                count += pendingDeferredCount.get();
            if (periodic)
                count += pendingPeriodicCount.get();
            if (background)
                count += pendingBackgroundCount.get();
        }
        if (running) {
            if (deferred)
                count += runningDeferredCount.get();
            if (periodic)
                count += runningPeriodicCount.get();
            if (background)
                count += runningBackgroundCount.get();
        }
        return count;
    }

    protected class WrappedRunnable implements Runnable {
        private final Runnable runnable;
        private final boolean deferred;
        private final boolean periodic;
        private final boolean background;
        private boolean cancelled;
        private boolean run;

        public WrappedRunnable(Runnable runnable, boolean deferred, boolean periodic, boolean background) {
            this.runnable = runnable;
            this.deferred = deferred;
            this.periodic = periodic;
            this.background = background;
            increasePendingCount();
        }

        public boolean isDeferred() {
            return deferred;
        }

        public boolean isPeriodic() {
            return periodic;
        }

        public boolean isBackground() {
            return background;
        }

        public boolean isCancelled() {
            return cancelled;
        }

        public void cancel() {
            if (!cancelled) {
                cancelled = true;
                if (!run)
                    decreasePendingCount();
            }
        }

        @Override
        public void run() {
            if (cancelled || run)
                return;
            run = true;
            decreasePendingCount();
            increaseRunningCount();
            try {
                runnable.run();
            } catch (Throwable t) {
                Console.log("Uncaught exception in scheduled runnable " + runnable, t);
            } finally {
                decreaseRunningCount();
                if (periodic && !cancelled) {
                    increasePendingCount();
                    run = false;
                }
            }
        }

        private void increasePendingCount() {
            if (deferred)
                pendingDeferredCount.incrementAndGet();
            else if (periodic)
                pendingPeriodicCount.incrementAndGet();
            else if (background)
                pendingBackgroundCount.incrementAndGet();
        }

        private void decreasePendingCount() {
            if (deferred)
                pendingDeferredCount.decrementAndGet();
            else if (periodic)
                pendingPeriodicCount.decrementAndGet();
            else if (background)
                pendingBackgroundCount.decrementAndGet();
        }

        private void increaseRunningCount() {
            if (deferred)
                runningDeferredCount.incrementAndGet();
            else if (periodic)
                runningPeriodicCount.incrementAndGet();
            else if (background)
                runningBackgroundCount.incrementAndGet();
        }

        private void decreaseRunningCount() {
            if (deferred)
                runningDeferredCount.decrementAndGet();
            else if (periodic)
                runningPeriodicCount.decrementAndGet();
            else if (background)
                runningBackgroundCount.decrementAndGet();
        }
    }

    protected class ScheduledBase implements Scheduled {

        protected final WrappedRunnable wrappedRunnable;

        public ScheduledBase(WrappedRunnable wrappedRunnable) {
            this.wrappedRunnable = wrappedRunnable;
        }

        @Override
        public boolean cancel() {
            if (!wrappedRunnable.cancelled) {
                if (cancelImpl()) {
                    wrappedRunnable.cancel();
                }
            }
            return wrappedRunnable.cancelled;
        }

        protected boolean cancelImpl() {
            return true;
        }
        
    }
}
