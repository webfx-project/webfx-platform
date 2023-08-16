// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation of the WindowLocation API (for platforms other than the browser).
 */
module webfx.platform.windowlocation.java {

    // Direct dependencies modules
    requires webfx.platform.windowhistory;
    requires webfx.platform.windowlocation;

    // Exported packages
    exports dev.webfx.platform.windowlocation.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.windowlocation.spi.WindowLocationProvider with dev.webfx.platform.windowlocation.spi.impl.java.JavaWindowLocationProvider;

}