package dev.webfx.platform.uischeduler.spi.impl.gwtj2cl;

import dev.webfx.platform.console.Console;
import dev.webfx.platform.scheduler.Cancellable;
import dev.webfx.platform.uischeduler.spi.impl.UiSchedulerProviderBase;
import elemental2.dom.DomGlobal;


/**
 * @author Bruno Salmon
 */
public final class GwtJ2clUiSchedulerProvider extends UiSchedulerProviderBase {

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
        double timeoutId = DomGlobal.setTimeout(ignored -> runnable.run(), delayMillis);
        return () -> {
            DomGlobal.clearTimeout(timeoutId);
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
