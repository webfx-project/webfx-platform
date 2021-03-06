// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.shared.scheduler {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.shared.util;

    // Exported packages
    exports dev.webfx.platform.shared.services.scheduler;
    exports dev.webfx.platform.shared.services.scheduler.spi;

    // Used services
    uses dev.webfx.platform.shared.services.scheduler.spi.SchedulerProvider;

}