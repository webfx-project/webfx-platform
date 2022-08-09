// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.windowlocation.java {

    // Direct dependencies modules
    requires webfx.platform.windowhistory;
    requires webfx.platform.windowlocation;

    // Exported packages
    exports dev.webfx.stack.platform.windowlocation.spi.impl.java;

    // Provided services
    provides dev.webfx.stack.platform.windowlocation.spi.WindowLocationProvider with dev.webfx.stack.platform.windowlocation.spi.impl.java.JavaWindowLocationProvider;

}