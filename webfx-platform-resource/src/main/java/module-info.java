// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform Resource API for accessing local resources (see {@link dev.webfx.platform.resource.Resource Resource}).
 */
module webfx.platform.resource {

    // Direct dependencies modules
    requires webfx.platform.service;

    // Exported packages
    exports dev.webfx.platform.resource;
    exports dev.webfx.platform.resource.spi;

    // Used services
    uses dev.webfx.platform.resource.spi.ResourceProvider;

}