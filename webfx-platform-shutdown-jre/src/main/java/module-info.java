// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation of the Shutdown API (for platforms other than browser and mobiles).
 */
module webfx.platform.shutdown.jre {

    // Direct dependencies modules
    requires webfx.platform.shutdown;

    // Exported packages
    exports dev.webfx.platform.shutdown.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.shutdown.spi.ShutdownProvider with dev.webfx.platform.shutdown.spi.impl.java.JavaShutdownProvider;

}