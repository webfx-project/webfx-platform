// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.shared.resource {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.shared.util;

    // Exported packages
    exports dev.webfx.platform.shared.services.resource;
    exports dev.webfx.platform.shared.services.resource.spi;

    // Used services
    uses dev.webfx.platform.shared.services.resource.spi.ResourceServiceProvider;

}