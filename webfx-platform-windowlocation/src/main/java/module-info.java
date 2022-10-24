// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.windowlocation {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.windowlocation;
    exports dev.webfx.platform.windowlocation.spi;
    exports dev.webfx.platform.windowlocation.spi.impl;

    // Used services
    uses dev.webfx.platform.windowlocation.spi.WindowLocationProvider;

}