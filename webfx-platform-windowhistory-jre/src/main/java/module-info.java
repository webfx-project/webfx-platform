// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation of the WindowHistory API (for platforms other than the browser).
 */
module webfx.platform.windowhistory.jre {

    // Direct dependencies modules
    requires webfx.platform.windowhistory;

    // Exported packages
    exports dev.webfx.platform.windowhistory.spi.impl.jre;

    // Provided services
    provides dev.webfx.platform.windowhistory.spi.WindowHistoryProvider with dev.webfx.platform.windowhistory.spi.impl.jre.JreWindowHistoryProvider;

}