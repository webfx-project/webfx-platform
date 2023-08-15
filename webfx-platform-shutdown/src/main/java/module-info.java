// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform API for shutting down WebFX applications (see {@link dev.webfx.platform.shutdown.Shutdown Shutdown}).
 */
module webfx.platform.shutdown {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.shutdown;
    exports dev.webfx.platform.shutdown.spi;
    exports dev.webfx.platform.shutdown.spi.impl;

    // Used services
    uses dev.webfx.platform.shutdown.spi.ShutdownProvider;

}