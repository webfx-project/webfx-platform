package dev.webfx.platform.shutdown.spi.impl.gluon;

import com.gluonhq.attach.lifecycle.LifecycleService;
import dev.webfx.platform.console.Console;
import dev.webfx.platform.os.OperatingSystem;
import dev.webfx.platform.shutdown.spi.impl.ShutdownProviderBase;
import dev.webfx.platform.uischeduler.UiScheduler;

/**
 * @author Bruno Salmon
 */
public final class GluonShutdownProvider extends ShutdownProviderBase<Thread> {

    private LifecycleService lifecycleService;

    public GluonShutdownProvider() {
        // Note: All Gluon servies must be created in UI thread, otherwise the application crashes
        UiScheduler.runInUiThread(() -> {
            lifecycleService = LifecycleService.create().orElse(null);
            if (lifecycleService == null)
                Console.log("WARNING [WebFX Platform]: Unable to load Gluon Lifecycle Service");
        });
    }

    @Override
    protected Thread createPlatformShutdownHook(Runnable hook) {
        return new Thread(hook);
    }

    @Override
    protected void addPlatformShutdownHook(Thread platformHook) {
        Runtime.getRuntime().addShutdownHook(platformHook);
    }

    @Override
    protected void removePlatformShutdownHook(Thread platformHook) {
        Runtime.getRuntime().removeShutdownHook(platformHook);
    }

    @Override
    public boolean canExit() {
        return !OperatingSystem.isIOS();
    }

    @Override
    protected void exit(int exitStatus) {
        if (lifecycleService != null) {
            Console.log("INFO [WebFX Platform]: Calling Gluon service shutdown");
            lifecycleService.shutdown(); // Note that it doesn't do anything on iOS as Apple prohibits applications to self exit
        }
    }
}
