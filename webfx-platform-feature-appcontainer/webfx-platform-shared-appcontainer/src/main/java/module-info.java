// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.shared.appcontainer {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.shared.log;
    requires webfx.platform.shared.shutdown;
    requires webfx.platform.shared.util;

    // Exported packages
    exports dev.webfx.platform.shared.services.appcontainer;
    exports dev.webfx.platform.shared.services.appcontainer.spi;
    exports dev.webfx.platform.shared.services.appcontainer.spi.impl;

    // Used services
    uses dev.webfx.platform.shared.services.appcontainer.spi.ApplicationContainerProvider;
    uses dev.webfx.platform.shared.services.appcontainer.spi.ApplicationJob;
    uses dev.webfx.platform.shared.services.appcontainer.spi.ApplicationModuleInitializer;

    // Provided services
    provides dev.webfx.platform.shared.services.appcontainer.spi.ApplicationModuleInitializer with dev.webfx.platform.shared.services.appcontainer.spi.impl.ApplicationJobsStarter;

}