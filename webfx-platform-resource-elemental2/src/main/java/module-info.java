// File managed by WebFX (DO NOT EDIT MANUALLY)

import dev.webfx.platform.resource.spi.impl.elemental2.Elemental2ResourceProvider;

/**
 * GWT/J2CL implementation of the Resource API (for the browser).
 */
module webfx.platform.resource.elemental2 {

    // Direct dependencies modules
    requires webfx.platform.resource;
    requires webfx.platform.resource.web;
    requires elemental2.dom;
    requires elemental2.promise;

    // Exported packages
    exports dev.webfx.platform.resource.spi.impl.elemental2;

    // Provided services
    provides dev.webfx.platform.resource.spi.ResourceProvider with Elemental2ResourceProvider;

}