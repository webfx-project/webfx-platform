// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform WindowLocation API for accessing the window location (see {@link dev.webfx.platform.windowlocation.WindowLocation WindowLocation}).
 */
module webfx.platform.windowlocation {

    // Direct dependencies modules
    requires webfx.platform.service;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.windowlocation;
    exports dev.webfx.platform.windowlocation.spi;
    exports dev.webfx.platform.windowlocation.spi.impl;

    // Used services
    uses dev.webfx.platform.windowlocation.spi.WindowLocationProvider;

}