package dev.webfx.platform.uischeduler.spi;

import dev.webfx.platform.scheduler.Scheduled;
import dev.webfx.platform.scheduler.spi.SchedulerProvider;
import dev.webfx.platform.util.tuples.Unit;
import dev.webfx.platform.uischeduler.AnimationFramePass;
import java.util.function.Consumer;

/**
 * @author Bruno Salmon
 */
public interface UiSchedulerProvider extends SchedulerProvider {

    /**
     * Whether there is a UI thread to marshal onto yet — asked by code that must decide between running
     * something inline and handing it to {@link #runInUiThread}.
     *
     * <h3>Why it lives here and not on the UI kit</h3>
     *
     * <p>It used to be asked of {@code WebFxKitLauncher.isReady()}, which meant any module needing the answer
     * required {@code webfx-kit-launcher} — and through it real JavaFX. {@code webfx-stack-session-state-client}
     * did, for this one question, which is how a headless command-line client came to carry javafx-base and
     * javafx-graphics and to boot a UI kit launcher purely to be told there was nothing to launch. The question
     * is about the SCHEDULER, so each scheduler provider can answer it without anybody depending on a kit.
     *
     * <h3>Why the default is false</h3>
     *
     * <p>Because the two wrong answers are not equally wrong. False means "run it inline", which is safe at
     * boot and is what the code asking this already did when no kit was present. True means "marshal it", and a
     * provider that DEFERS until a UI exists would queue boot-time work for a moment that never comes — which
     * is not hypothetical: {@code OpenJFXUiSchedulerProvider} posts to {@code WebFxKitLauncher.onReady(...)},
     * and a command-line program never launches a JavaFX application. A provider with a real UI thread that
     * forgets to override this runs some callbacks inline, which is loud if it matters; the inverse hangs
     * silently.
     */
    default boolean isUiThreadReady() {
        return false;
    }

    void requestNextScenePulse();

    boolean isAnimationFrameNow();

    int getAnimationFrameNumber();

    Scheduled scheduleDelayInAnimationFrame(long delayMs, Runnable animationTask, int afterFrameCount, AnimationFramePass pass);

    // Note: may be in the same animation frame if delay makes it possible
    default Scheduled scheduleDelayInAnimationFrame(long delayMs, Runnable animationTask, AnimationFramePass pass) {
        return scheduleDelayInAnimationFrame(delayMs, animationTask, 0, pass);
    }

    // Excludes the possibility for an execution in the current animation frame (if called during an animation frame)
    default Scheduled scheduleDelayInFutureAnimationFrame(long delayMs, Runnable animationTask, AnimationFramePass pass) {
        return scheduleDelayInAnimationFrame(delayMs, animationTask, isAnimationFrameNow() ? 1 : 0, pass);
    }

    // Same API but with no delay

    default Scheduled scheduleInAnimationFrame(Runnable animationTask, int afterFrameCount, AnimationFramePass pass) {
        return scheduleDelayInAnimationFrame(0, animationTask, afterFrameCount, pass);
    }

    // Note: may be in the same animation frame if possible
    default Scheduled scheduleInAnimationFrame(Runnable animationTask, AnimationFramePass pass) {
        return scheduleDelayInAnimationFrame(0, animationTask, pass);
    }

    // Excludes the possibility for an execution in the current animation frame (if called during an animation frame)
    default Scheduled scheduleInFutureAnimationFrame(Runnable animationTask, AnimationFramePass pass) {
        return scheduleDelayInFutureAnimationFrame(0, animationTask, pass);
    }

    // Correct way of scheduling a property change in the next animation frame
    default Scheduled schedulePropertyChangeInAnimationFrame(Runnable propertyChangeTask) {
        return scheduleInAnimationFrame(propertyChangeTask, AnimationFramePass.PROPERTY_CHANGE_PASS);
    }

    // Periodic API

    // With an initial delay first, then on each animation frame until cancellation
    Scheduled schedulePeriodicInAnimationFrame(long delayMs, Runnable animationTask, AnimationFramePass pass);

    // Same but without initial delay
    default Scheduled schedulePeriodicInAnimationFrame(Runnable animationTask, AnimationFramePass pass) {
        return schedulePeriodicInAnimationFrame(0, animationTask, pass);
    }


    // Same Periodic API but with Consumer to make the cancellation easier
    default Scheduled schedulePeriodicInAnimationFrame(long delayMs, Consumer<Scheduled> animationTask, AnimationFramePass pass) {
        Unit<Scheduled> scheduledHolder = new Unit<>();
        Scheduled scheduled = schedulePeriodicInAnimationFrame(delayMs, () -> animationTask.accept(scheduledHolder.get()), pass);
        scheduledHolder.set(scheduled);
        return scheduled;
    }


    default Scheduled schedulePeriodicInAnimationFrame(Consumer<Scheduled> animationTask, AnimationFramePass pass) {
        return schedulePeriodicInAnimationFrame(0, animationTask, pass);
    }


    // Finally, repeating the same API but without specifying the animation frame pass (implicitly UI_UPDATE_PASS)

    default Scheduled scheduleDelayInAnimationFrame(long delayMs, Runnable animationTask, int afterFrameCount) {
        return scheduleDelayInAnimationFrame(delayMs, animationTask, afterFrameCount, AnimationFramePass.UI_UPDATE_PASS);
    }

    default Scheduled scheduleDelayInAnimationFrame(long delayMs, Runnable animationTask) {
        return scheduleDelayInAnimationFrame(delayMs, animationTask, AnimationFramePass.UI_UPDATE_PASS);
    }

    default Scheduled scheduleDelayInFutureAnimationFrame(long delayMs, Runnable animationTask) {
        return scheduleDelayInFutureAnimationFrame(delayMs, animationTask, AnimationFramePass.UI_UPDATE_PASS);
    }

    default Scheduled scheduleInAnimationFrame(Runnable animationTask, int afterFrameCount) {
        return scheduleInAnimationFrame(animationTask, afterFrameCount, AnimationFramePass.UI_UPDATE_PASS);
    }

    default Scheduled scheduleInAnimationFrame(Runnable animationTask) {
        return scheduleInAnimationFrame(animationTask, AnimationFramePass.UI_UPDATE_PASS);
    }

    default Scheduled scheduleInFutureAnimationFrame(Runnable animationTask) {
        return scheduleInFutureAnimationFrame(animationTask, AnimationFramePass.UI_UPDATE_PASS);
    }

    default Scheduled schedulePeriodicInAnimationFrame(long delayMs, Runnable animationTask) {
        return schedulePeriodicInAnimationFrame(delayMs, animationTask, AnimationFramePass.UI_UPDATE_PASS);
    }

    default Scheduled schedulePeriodicInAnimationFrame(Runnable animationTask) {
        return schedulePeriodicInAnimationFrame(animationTask, AnimationFramePass.UI_UPDATE_PASS);
    }

    default Scheduled schedulePeriodicInAnimationFrame(long delayMs, Consumer<Scheduled> animationTask) {
        return schedulePeriodicInAnimationFrame(delayMs, animationTask, AnimationFramePass.UI_UPDATE_PASS);
    }

    default Scheduled schedulePeriodicInAnimationFrame(Consumer<Scheduled> animationTask) {
        return schedulePeriodicInAnimationFrame(animationTask, AnimationFramePass.UI_UPDATE_PASS);
    }
}
