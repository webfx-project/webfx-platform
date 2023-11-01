package dev.webfx.platform.uischeduler.spi.impl.gwt;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Timer;
import dev.webfx.platform.console.Console;
import dev.webfx.platform.scheduler.Scheduled;
import dev.webfx.platform.uischeduler.spi.impl.UiSchedulerProviderBase;


/**
 * @author Bruno Salmon
 */
public final class GwtUiSchedulerProvider extends UiSchedulerProviderBase {

    @Override
    public boolean isUiThread() {
        return true;
    }

    private JavaScriptObject animationFrameId;

    @Override
    protected void requestAnimationFrame(Runnable runnable) {
        animationFrameId = jsRequestAnimationFrame(runnable);
    }

    @Override
    protected void cancelAnimationFrame() {
        jsCancelAnimationFrame(animationFrameId);
    }

    protected Scheduled scheduleLongTermAnimation(long delayMillis, Runnable runnable) {
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

    private static native JavaScriptObject jsRequestAnimationFrame(Runnable runnable) /*-{
        return $wnd.requestAnimationFrame(runnable.@java.lang.Runnable::run().bind(runnable));
    }-*/;

    private static native void jsCancelAnimationFrame(JavaScriptObject id) /*-{
        return $wnd.cancelAnimationFrame(id);
    }-*/;

    @Override
    protected void log(String message) {
        Console.log(message);
    }

    @Override
    protected void log(Throwable throwable) {
        Console.log(throwable);
    }
}
