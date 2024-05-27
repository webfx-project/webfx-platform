package dev.webfx.platform.boot.spi;

import dev.webfx.platform.boot.spi.impl.ApplicationModuleBooterManager;
import dev.webfx.platform.boot.spi.impl.SimpleApplicationJobManager;
import dev.webfx.platform.shutdown.Shutdown;

/**
 * @author Bruno Salmon
 */
public interface ApplicationBooterProvider {

    default void boot() {
        ApplicationModuleBooterManager.initialize();
        Shutdown.addShutdownHook(SimpleApplicationJobManager::shutdown);
        Shutdown.addShutdownHook(ApplicationModuleBooterManager::shutdown);
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

}
