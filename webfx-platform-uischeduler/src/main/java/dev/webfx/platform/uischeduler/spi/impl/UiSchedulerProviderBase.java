package dev.webfx.platform.uischeduler.spi.impl;

import dev.webfx.platform.scheduler.Scheduled;
import dev.webfx.platform.scheduler.Scheduler;
import dev.webfx.platform.scheduler.spi.SchedulerProviderBase;
import dev.webfx.platform.uischeduler.AnimationFramePass;
import dev.webfx.platform.uischeduler.spi.UiSchedulerProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Salmon
 */
public abstract class UiSchedulerProviderBase extends SchedulerProviderBase implements UiSchedulerProvider {

    private final static long MILLIS_IN_NANO = 1_000_000;
    private final static long SECOND_IN_NANO = 1_000 * MILLIS_IN_NANO;
    private final static long MAX_ANIMATION_FRAME_DURATION_NANO = SECOND_IN_NANO / 60;
    private final static boolean LOG_LONG_ANIMATIONS = false;
    private final static boolean LOG_DOT = false;
    private long nextAnimationExecutionTime;
    private boolean animationFrameRequested;
    private Scheduled longTermAnimationScheduled;
    private long longTermAnimationScheduledTimeMillis;

    @Override
    public Scheduled scheduleDelayInAnimationFrame(long delayMs, Runnable animationTask, int afterFrameCount, AnimationFramePass pass) {
        return scheduleInAnimationFrameImpl(delayMs, animationTask, afterFrameCount, pass, true, false, false);
    }

    @Override
    public Scheduled schedulePeriodic(long delayMs, Runnable runnable) {
        return schedulePeriodicInAnimationFrame(delayMs, runnable, AnimationFramePass.UI_UPDATE_PASS);
    }

    @Override
    public Scheduled schedulePeriodicInAnimationFrame(long delayMs, Runnable animationTask, AnimationFramePass pass) {
        return scheduleInAnimationFrameImpl(delayMs, animationTask, 0, pass, false, true, false);
    }

    private Scheduled scheduleInAnimationFrameImpl(long delayMs, Runnable animationTask, int afterFrameCount, AnimationFramePass pass, boolean deferred, boolean periodic, boolean background) {
        return scheduleInAnimationFrameImpl(delayMs, new WrappedRunnable(animationTask, deferred, periodic, background), afterFrameCount, pass);
    }

    private ScheduledBase scheduleInAnimationFrameImpl(long delayMs, WrappedRunnable wrappedRunnable, int afterFrameCount, AnimationFramePass pass) {
        return new AnimationScheduled(delayMs, wrappedRunnable, afterFrameCount, pass);
    }

    @Override
    protected ScheduledBase scheduledImpl(WrappedRunnable wrappedRunnable, long delayMs) {
        return scheduleInAnimationFrameImpl(delayMs, wrappedRunnable, 0, AnimationFramePass.UI_UPDATE_PASS);
    }

    @Override
    public void requestNextScenePulse() {
        scheduleNextAnimationExecution(false, false, System.currentTimeMillis());
    }

    public class AnimationScheduled extends ScheduledBase {
        private final long delayMs;
        private int futureFrameCount;
        private long nextExecutionTimeMillis;

        private AnimationScheduled(long delayMs, WrappedRunnable wrappedRunnable, int afterFrameCount, AnimationFramePass pass) {
            super(wrappedRunnable);
            this.delayMs = delayMs;
            this.futureFrameCount = afterFrameCount;
            nextExecutionTimeMillis = delayMs == 0 ? 0 : System.currentTimeMillis() + delayMs;
            switch (pass) {
                case UI_UPDATE_PASS: uiAnimations.add(this); break;
                case PROPERTY_CHANGE_PASS: propertiesAnimations.add(this); break;
                case SCENE_PULSE_LAYOUT_PASS: pulseAnimations.add(this); break;
            }
            scheduleNextAnimationExecution(false, false, nextExecutionTimeMillis);
        }

        @Override
        public boolean cancelImpl() {
            return true; // will be removed on next animation frame
        }

        private boolean isCancelled() {
            return wrappedRunnable.isCancelled();
        }

        private boolean isPeriodic() {
            return wrappedRunnable.isPeriodic();
        }

        private boolean shouldExecuteNow() {
            if (futureFrameCount > 0) {
                futureFrameCount--;
                return false;
            }
            return nextExecutionTimeMillis == 0 || System.currentTimeMillis() >= nextExecutionTimeMillis;
        }

        private void execute() {
            long nowMillis = System.currentTimeMillis();
            if (nextExecutionTimeMillis > 0 && nowMillis > nextExecutionTimeMillis + 16)
                log("🥵 Late by " + (nowMillis - nextExecutionTimeMillis) + "ms");
            wrappedRunnable.run();
            if (nextExecutionTimeMillis != 0 && wrappedRunnable.isPeriodic()) {
                nextExecutionTimeMillis += delayMs;
                if (nextExecutionTimeMillis < nowMillis) {
                    log("🤷");
                    nextExecutionTimeMillis = nowMillis + delayMs;
                }
            }
        }
    }

    private final List<AnimationScheduled> uiAnimations = new ArrayList<>();
    private final List<AnimationScheduled> propertiesAnimations = new ArrayList<>();
    private final List<AnimationScheduled> pulseAnimations = new ArrayList<>();
    private final ThreadLocal<Boolean> animationFrame = new ThreadLocal<>();
    @Override
    public boolean isAnimationFrameNow() {
        return animationFrame.get() == Boolean.TRUE;
    }

    protected void executeAnimationPipe() {
        nextAnimationExecutionTime = -1;
        animationFrame.set(Boolean.TRUE);
        long uiPassStart = System.nanoTime();
        executeAnimations(uiAnimations);
        long propertiesPassStart = System.nanoTime();
        executeAnimations(propertiesAnimations);
        long pulsePassStart = System.nanoTime();
        executeAnimations(pulseAnimations);
        long nanoEnd = System.nanoTime();
        long animationDuration = nanoEnd - uiPassStart;
        animationFrame.set(Boolean.FALSE);

        // Logging
        if (LOG_LONG_ANIMATIONS && animationDuration > MAX_ANIMATION_FRAME_DURATION_NANO) {
            log("Long animation: " + animationDuration / MILLIS_IN_NANO + "ms (60 FPS = 16ms) = "
                    + (propertiesPassStart - uiPassStart) / MILLIS_IN_NANO + "ms ui + "
                    + (pulsePassStart - propertiesPassStart) / MILLIS_IN_NANO + "ms properties + "
                    + (nanoEnd - pulsePassStart) / MILLIS_IN_NANO + "ms layout/pulse");
        } else if (LOG_DOT)
            log(".");

        // Scheduling next animation frame
        scheduleNextAnimationExecution(nextAnimationExecutionTime == -1, true, nextAnimationExecutionTime);
    }

    private void executeAnimations(List<AnimationScheduled> animations) {
        for (int i = 0; i < animations.size(); i++) {
            AnimationScheduled scheduled = animations.get(i);
            if (scheduled.isCancelled())
                animations.remove(i--);
            else {
                if (scheduled.shouldExecuteNow()) {
                    scheduled.execute();
                    if (!scheduled.isPeriodic() || scheduled.isCancelled()) {
                        animations.remove(i--);
                        continue;
                    }
                }
                // If we reach this point, it means this scheduled will be executed in the future (either again or for
                // the first time). We eventually reschedule the next animation execution time for this.
                if (animations == pulseAnimations)
                    continue;
                if (nextAnimationExecutionTime == -1 || nextAnimationExecutionTime > scheduled.nextExecutionTimeMillis)
                    nextAnimationExecutionTime = scheduled.nextExecutionTimeMillis;
            }
        }
    }

    protected void scheduleNextAnimationExecution(boolean stop, boolean reset, long nextAnimationExecutionTimeMillis) {
        if (!reset && !stop && animationFrameRequested)
            return;
        long nowMillis = System.currentTimeMillis();
        long delayMillis = nextAnimationExecutionTimeMillis - nowMillis;
        boolean preferAnimationFrame = !stop && delayMillis < 50;
        if (preferAnimationFrame) {
            if (longTermAnimationScheduled != null) {
                longTermAnimationScheduled.cancel();
                longTermAnimationScheduled = null;
            }
            requestAnimationFrame(this::executeAnimationPipe);
            animationFrameRequested = true;
        } else {
            cancelAnimationFrame();
            animationFrameRequested = false;
            if (longTermAnimationScheduled != null) {
                if (!stop && !reset && longTermAnimationScheduledTimeMillis <= nextAnimationExecutionTimeMillis)
                    return;
                if (!stop && reset && longTermAnimationScheduledTimeMillis == nextAnimationExecutionTimeMillis)
                    return;
                longTermAnimationScheduled.cancel();
                longTermAnimationScheduled = null;
            }
            if (stop)
                return;
            longTermAnimationScheduledTimeMillis = nextAnimationExecutionTimeMillis;
            longTermAnimationScheduled = scheduleLongTermAnimation(delayMillis, () -> {
                longTermAnimationScheduled = null;
                executeAnimationPipe();
            });
        }
    }

    protected abstract void requestAnimationFrame(Runnable runnable);
    protected abstract void cancelAnimationFrame();

    protected Scheduled scheduleLongTermAnimation(long delayMillis, Runnable runnable) {
        // This default implementation assumes Scheduler.scheduleDelay() has its own independent implementation (so it
        // doesn't loop back to this UiScheduler). If not, it needs to be overridden.
        return Scheduler.scheduleDelay(delayMillis, runnable);
    }

    protected void log(String message) {
        System.out.println(message);
    }

    protected void log(Throwable throwable) {
        throwable.printStackTrace(System.err);
    }

}
