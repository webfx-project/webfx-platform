package dev.webfx.platform.scheduler.spi.impl.vertx;

import io.vertx.core.Vertx;
import dev.webfx.platform.scheduler.Scheduled;
import dev.webfx.platform.vertx.common.VertxInstance;
import dev.webfx.platform.scheduler.spi.SchedulerProvider;

/**
 * @author Bruno Salmon
 */
public final class VertxSchedulerProvider implements SchedulerProvider {

    private final Vertx vertx = VertxInstance.getVertx();

    @Override
    public void scheduleDeferred(Runnable runnable) {
        scheduleDelay(1, runnable);
    }

    @Override
    public VertxScheduled scheduleDelay(long delayMs, Runnable runnable) {
        return new VertxScheduled(vertx.setTimer(delayMs, event -> runnable.run()));
    }

    @Override
    public VertxScheduled schedulePeriodic(long delayMs, Runnable runnable) {
        return new VertxScheduled(vertx.setPeriodic(delayMs, event -> runnable.run()));
    }

    @Override
    public long nanoTime() {
        return System.nanoTime();
    }

    @Override
    public int availableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    private final class VertxScheduled implements Scheduled {
        private final long timerId;

        private VertxScheduled(long timerId) {
            this.timerId = timerId;
        }

        @Override
        public boolean cancel() {
            return vertx.cancelTimer(timerId);
        }
    }
}
