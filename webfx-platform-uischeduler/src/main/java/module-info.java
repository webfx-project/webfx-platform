// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * 
        Cross-platform UiScheduler API for scheduling UI tasks
        (see {@link dev.webfx.platform.uischeduler.UiScheduler UiScheduler}).
        It's an extension of the Scheduler API with additional methods for handling UI tasks.
        The WebFX Platform provides only the GWT implementation. The WebFX Kit provides the OpenJFX implementation.
    
 */
module webfx.platform.uischeduler {

    // Direct dependencies modules
    requires webfx.platform.console;
    requires transitive webfx.platform.scheduler;
    requires webfx.platform.service;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.uischeduler;
    exports dev.webfx.platform.uischeduler.spi;
    exports dev.webfx.platform.uischeduler.spi.impl;

    // Used services
    uses dev.webfx.platform.uischeduler.spi.UiSchedulerProvider;

}