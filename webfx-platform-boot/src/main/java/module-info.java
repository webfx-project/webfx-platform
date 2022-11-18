// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.boot {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.console;
    requires webfx.platform.shutdown;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.boot;
    exports dev.webfx.platform.boot.spi;
    exports dev.webfx.platform.boot.spi.impl;

    // Used services
    uses dev.webfx.platform.boot.spi.ApplicationBooterProvider;
    uses dev.webfx.platform.boot.spi.ApplicationJob;
    uses dev.webfx.platform.boot.spi.ApplicationModuleBooter;

    // Provided services
    provides dev.webfx.platform.boot.spi.ApplicationModuleBooter with dev.webfx.platform.boot.spi.impl.ApplicationJobsBooter;

}