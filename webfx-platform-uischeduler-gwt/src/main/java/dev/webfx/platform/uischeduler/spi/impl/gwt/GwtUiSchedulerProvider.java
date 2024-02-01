package dev.webfx.platform.uischeduler.spi.impl.gwt;

import com.google.gwt.user.client.Timer;
import dev.webfx.platform.console.Console;
import dev.webfx.platform.scheduler.Cancellable;
import dev.webfx.platform.uischeduler.spi.impl.UiSchedulerProviderBase;
import elemental2.dom.DomGlobal;


/**
 * @author Bruno Salmon
 */
public final class GwtUiSchedulerProvider extends UiSchedulerProviderBase {

    @Override
    public boolean isUiThread() {
        return true;
    }

    private int animationFrameId;

    @Override
    protected void requestAnimationFrame(Runnable runnable) {
        animationFrameId = DomGlobal.requestAnimationFrame(timestamp -> runnable.run());
    }

    @Override
    protected void cancelAnimationFrame() {
        DomGlobal.cancelAnimationFrame(animationFrameId);
    }

    protected Cancellable scheduleLongTermAnimation(long delayMillis, Runnable runnable) {
        Timer timer = new Timer() {
            @Override
            public void run() {
                runnable.run();
            }
        };
        timer.schedule((int) delayMillis);
        return () -> {
            timer.cancel();
            return true;
        };
    }

    @Override
    protected void log(String message) {
        Console.log(message);
    }

    @Override
    protected void log(Throwable throwable) {
        Console.log(throwable);
    }
}
