// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.windowhistory {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.async;
    requires webfx.platform.json;
    requires webfx.platform.util;
    requires webfx.platform.windowlocation;

    // Exported packages
    exports dev.webfx.platform.windowhistory;
    exports dev.webfx.platform.windowhistory.spi;
    exports dev.webfx.platform.windowhistory.spi.impl;

    // Used services
    uses dev.webfx.platform.windowhistory.spi.WindowHistoryProvider;

}