// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.uischeduler {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.scheduler;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.uischeduler;
    exports dev.webfx.platform.uischeduler.spi;
    exports dev.webfx.platform.uischeduler.spi.impl;

    // Used services
    uses dev.webfx.platform.uischeduler.spi.UiSchedulerProvider;

}