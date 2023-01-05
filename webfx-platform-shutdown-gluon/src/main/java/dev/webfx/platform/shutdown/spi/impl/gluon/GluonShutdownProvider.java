package dev.webfx.platform.shutdown.spi.impl.gluon;

import dev.webfx.platform.shutdown.spi.impl.ShutdownProviderBase;

import com.gluonhq.attach.lifecycle.LifecycleService;

/**
 * @author Bruno Salmon
 */
public final class GluonShutdownProvider extends ShutdownProviderBase<Thread> {

    private final LifecycleService lifecycleService = LifecycleService.create().get();

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
    protected void exit(int exitStatus) {
        lifecycleService.shutdown();
    }
}
