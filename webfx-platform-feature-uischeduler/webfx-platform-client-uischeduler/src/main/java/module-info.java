// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.client.uischeduler {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.shared.scheduler;
    requires webfx.platform.shared.util;

    // Exported packages
    exports dev.webfx.platform.client.services.uischeduler;
    exports dev.webfx.platform.client.services.uischeduler.spi;
    exports dev.webfx.platform.client.services.uischeduler.spi.impl;

    // Used services
    uses dev.webfx.platform.client.services.uischeduler.spi.UiSchedulerProvider;

}