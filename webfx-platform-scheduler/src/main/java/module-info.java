// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * 
        Cross-platform Scheduler API for scheduling non-UI tasks
        (see {@link dev.webfx.platform.scheduler.Scheduler Scheduler}).
        The GWT implementation is indirectly provided by the UiScheduler API (an extension of the Scheduler API with
        additional methods for UI tasks), because there is no distinction in terms of implementation between these 2
        APIs for the browser (due to its mono-thread nature).
    
 */
module webfx.platform.scheduler {

    // Direct dependencies modules
    requires webfx.platform.console;
    requires webfx.platform.service;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.scheduler;
    exports dev.webfx.platform.scheduler.spi;

    // Used services
    uses dev.webfx.platform.scheduler.spi.SchedulerProvider;

}