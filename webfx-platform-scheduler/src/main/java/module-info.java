// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform API for scheduling non-UI tasks (see {@link dev.webfx.platform.scheduler.Scheduler Scheduler})
 */
module webfx.platform.scheduler {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.console;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.scheduler;
    exports dev.webfx.platform.scheduler.spi;

    // Used services
    uses dev.webfx.platform.scheduler.spi.SchedulerProvider;

}