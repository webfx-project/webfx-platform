package dev.webfx.platform.boot.spi;

import dev.webfx.platform.boot.spi.impl.ApplicationModuleBooterManager;

/**
 * @author Bruno Salmon
 */
public interface ApplicationJob {

    default void onInit() {} // Called on APPLICATION_BOOT_LEVEL

    default void onStart() {} // Called on JOBS_START_BOOT_LEVEL

    default void onStop() {} // Called on shutdown

    default void log(String message) {
        ApplicationModuleBooterManager.log(message);
    }

}
