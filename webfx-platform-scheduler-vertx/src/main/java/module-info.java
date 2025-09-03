// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Vert.x implementation of the Scheduler API (for the server).
 */
module webfx.platform.scheduler.vertx {

    // Direct dependencies modules
    requires io.vertx.core;
    requires webfx.platform.scheduler;
    requires webfx.platform.util.vertx;

    // Exported packages
    exports dev.webfx.platform.scheduler.spi.impl.vertx;

    // Provided services
    provides dev.webfx.platform.scheduler.spi.SchedulerProvider with dev.webfx.platform.scheduler.spi.impl.vertx.VertxSchedulerProvider;

}