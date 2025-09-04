package dev.webfx.platform.uischeduler.spi.impl.teavm;

import dev.webfx.platform.scheduler.Cancellable;
import dev.webfx.platform.uischeduler.spi.impl.UiSchedulerProviderBase;
import dev.webfx.platform.util.teavm.TeaVmUtil;
import org.teavm.jso.browser.Window;

/**
 * @author Bruno Salmon
 */
public final class TeaVmUiSchedulerProvider extends UiSchedulerProviderBase {

    {
        // The browser is stopping animation frames when the tab is hidden, so we ensure all pending animation tasks
        // are executed as soon as the user goes back to the tab.
        Window.current().getDocument().addEventListener("visibilitychange", evt -> executeAnimationPipe());
    }

    @Override
    public boolean isUiThread() {
        return true;
    }

    private int animationFrameId;

    @Override
    protected boolean isSystemAnimationFrameRunning() {
        // Usually the browsers stop honoring animation frames on hidden tabs
        boolean isBrowserTabHidden = "hidden".equals(TeaVmUtil.getVisibilityState());
        return !isBrowserTabHidden;
    }

    @Override
    protected void requestAnimationFrame(Runnable runnable) {
        animationFrameId = Window.requestAnimationFrame(timestamp -> runnable.run());
    }

    @Override
    protected void cancelAnimationFrame() {
        Window.cancelAnimationFrame(animationFrameId);
    }

    protected Cancellable scheduleLongTermAnimation(long delayMillis, Runnable runnable) {
        int timeoutId = Window.setTimeout(runnable::run, (int) delayMillis);
        return () -> {
            Window.clearTimeout(timeoutId);
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