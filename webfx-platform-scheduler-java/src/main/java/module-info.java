// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation of the Scheduler API (for platforms other than browser adn server).
 */
module webfx.platform.scheduler.java {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.scheduler;

    // Exported packages
    exports dev.webfx.platform.scheduler.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.scheduler.spi.SchedulerProvider with dev.webfx.platform.scheduler.spi.impl.java.JavaSchedulerProvider;

}