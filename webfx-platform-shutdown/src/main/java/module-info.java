// File managed by WebFX (DO NOT EDIT MANUALLY)

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