// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.scheduler {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.scheduler;
    exports dev.webfx.platform.scheduler.spi;

    // Used services
    uses dev.webfx.platform.scheduler.spi.SchedulerProvider;

}