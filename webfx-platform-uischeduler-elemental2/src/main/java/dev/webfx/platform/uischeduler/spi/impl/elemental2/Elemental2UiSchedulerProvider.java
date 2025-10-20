package dev.webfx.platform.uischeduler.spi.impl.elemental2;

import dev.webfx.platform.scheduler.Cancellable;
import dev.webfx.platform.uischeduler.spi.impl.UiSchedulerProviderBase;
import elemental2.dom.DomGlobal;


/**
 * @author Bruno Salmon
 */
public final class Elemental2UiSchedulerProvider extends UiSchedulerProviderBase {

    {
        // The browser is stopping animation frames when the tab is hidden, so we ensure all pending animation tasks
        // are executed as soon as the user goes back to the tab.
        DomGlobal.document.addEventListener("visibilitychange", evt -> executeAnimationPipe());
    }

    @Override
    public boolean isUiThread() {
        return true;
    }

    private int animationFrameId;

    @Override
    protected boolean isSystemAnimationFrameRunning() {
        // Usually the browsers stop honoring animation frames on hidden tabs
        boolean isBrowserTabHidden = "hidden".equalsIgnoreCase(DomGlobal.document.visibilityState);
        return !isBrowserTabHidden;
    }

    @Override
    protected void requestAnimationFrame(Runnable runnable) {
        animationFrameId = DomGlobal.requestAnimationFrame(timestamp -> runnable.run());
    }

    @Override
    protected void cancelAnimationFrame() {
        DomGlobal.cancelAnimationFrame(animationFrameId);
    }

    protected Cancellable scheduleLongTermAnimation(long delayMillis, Runnable runnable) {
        double timeoutId = DomGlobal.setTimeout(ignored -> runnable.run(), delayMillis);
        return () -> {
            DomGlobal.clearTimeout(timeoutId);
            return true;
        };
    }

    @Override
    public void wakeUp() {
        if (!isSystemAnimationFrameRunning()) {
            executeAnimationPipe();
        }
    }

}
