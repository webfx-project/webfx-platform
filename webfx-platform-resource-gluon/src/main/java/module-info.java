// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.resource.gluon {

    // Direct dependencies modules
    requires webfx.platform.resource;
    requires webfx.platform.resource.java;

    // Exported packages
    exports dev.webfx.platform.resource.spi.impl.gluon;

    // Provided services
    provides dev.webfx.platform.resource.spi.ResourceProvider with dev.webfx.platform.resource.spi.impl.gluon.GluonResourceProvider;

}