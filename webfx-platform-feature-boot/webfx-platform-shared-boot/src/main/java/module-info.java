// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.shared.boot {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.shared.async;
    requires webfx.platform.shared.log;
    requires webfx.platform.shared.shutdown;
    requires webfx.platform.shared.util;

    // Exported packages
    exports dev.webfx.platform.shared.services.boot;
    exports dev.webfx.platform.shared.services.boot.spi;
    exports dev.webfx.platform.shared.services.boot.spi.impl;

    // Used services
    uses dev.webfx.platform.shared.services.boot.spi.ApplicationBooterProvider;
    uses dev.webfx.platform.shared.services.boot.spi.ApplicationJob;
    uses dev.webfx.platform.shared.services.boot.spi.ApplicationModuleBooter;

    // Provided services
    provides dev.webfx.platform.shared.services.boot.spi.ApplicationModuleBooter with dev.webfx.platform.shared.services.boot.spi.impl.ApplicationJobsBooter;

}