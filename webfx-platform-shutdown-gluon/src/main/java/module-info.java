// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Gluon implementation of the Shutdown API (for mobiles).
 */
module webfx.platform.shutdown.gluon {

    // Direct dependencies modules
    requires com.gluonhq.attach.lifecycle;
    requires webfx.platform.console;
    requires webfx.platform.os;
    requires webfx.platform.scheduler;
    requires webfx.platform.shutdown;

    // Exported packages
    exports dev.webfx.platform.shutdown.spi.impl.gluon;

    // Provided services
    provides dev.webfx.platform.shutdown.spi.ShutdownProvider with dev.webfx.platform.shutdown.spi.impl.gluon.GluonShutdownProvider;

}