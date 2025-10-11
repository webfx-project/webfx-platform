// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation of the Resource API (for platforms other than browser).
 */
module webfx.platform.resource.jre {

    // Direct dependencies modules
    requires webfx.platform.resource;

    // Exported packages
    exports dev.webfx.platform.resource.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.resource.spi.ResourceProvider with dev.webfx.platform.resource.spi.impl.java.JavaResourceProvider;

}