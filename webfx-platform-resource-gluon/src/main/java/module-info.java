// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Gluon implementation of the Resource API (for mobiles).
 */
module webfx.platform.resource.gluon {

    // Direct dependencies modules
    requires webfx.platform.resource;
    requires webfx.platform.resource.jre;

    // Exported packages
    exports dev.webfx.platform.resource.spi.impl.gluon;

    // Provided services
    provides dev.webfx.platform.resource.spi.ResourceProvider with dev.webfx.platform.resource.spi.impl.gluon.GluonResourceProvider;

}