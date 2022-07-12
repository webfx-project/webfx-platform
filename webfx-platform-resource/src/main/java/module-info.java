// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.resource {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.resource;
    exports dev.webfx.platform.resource.spi;

    // Used services
    uses dev.webfx.platform.resource.spi.ResourceProvider;

}