// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.windowhistory.java {

    // Direct dependencies modules
    requires webfx.platform.windowhistory;

    // Exported packages
    exports dev.webfx.platform.windowhistory.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.windowhistory.spi.WindowHistoryProvider with dev.webfx.platform.windowhistory.spi.impl.java.JavaWindowHistoryProvider;

}