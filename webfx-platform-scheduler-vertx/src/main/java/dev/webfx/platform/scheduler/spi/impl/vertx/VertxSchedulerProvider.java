package dev.webfx.platform.scheduler.spi.impl.vertx;

import dev.webfx.platform.scheduler.spi.SchedulerProviderBase;
import dev.webfx.platform.vertx.common.VertxInstance;
import io.vertx.core.Vertx;

/**
 * @author Bruno Salmon
 */
public final class VertxSchedulerProvider extends SchedulerProviderBase {

    private final Vertx vertx = VertxInstance.getVertx();

    @Override
    protected ScheduledBase scheduledImpl(WrappedRunnable wrappedRunnable, long delayMs) {
        long timerId;
        if (wrappedRunnable.isPeriodic())
            timerId = vertx.setPeriodic(delayMs, event -> wrappedRunnable.run());
        else
            timerId = vertx.setTimer(delayMs, event -> wrappedRunnable.run());
        return new VertxScheduled(wrappedRunnable, timerId);
    }

    private final class VertxScheduled extends ScheduledBase {
        private final long timerId;

        public VertxScheduled(WrappedRunnable wrappedRunnable, long timerId) {
            super(wrappedRunnable);
            this.timerId = timerId;
        }

        @Override
        public boolean cancelImpl() {
            return vertx.cancelTimer(timerId);
        }
    }
}
