package dev.webfx.platform.boot.spi;

import dev.webfx.platform.boot.spi.impl.ApplicationModuleBooterManager;
import dev.webfx.platform.boot.spi.impl.SimpleApplicationJobManager;
import dev.webfx.platform.shutdown.Shutdown;
import dev.webfx.platform.shutdown.ShutdownEventType;

/**
 * @author Bruno Salmon
 */
public interface ApplicationBooterProvider {

    default void boot() {
        defaultBoot();
    }

    default void initApplicationJob(ApplicationJob applicationJob) {
        SimpleApplicationJobManager.initApplicationJob(applicationJob);
    }

    default void startApplicationJob(ApplicationJob applicationJob) {
        SimpleApplicationJobManager.startApplicationJob(applicationJob);
    }

    default void stopApplicationJob(ApplicationJob applicationJob) {
        SimpleApplicationJobManager.stopApplicationJob(applicationJob);
    }

    static void defaultBoot() {
        ApplicationModuleBooterManager.initialize();
        Shutdown.addShutdownHook(e -> {
            if (e.getType() == ShutdownEventType.EXIT) {
                SimpleApplicationJobManager.shutdown();
                ApplicationModuleBooterManager.shutdown();
            }
        });
    }

}
