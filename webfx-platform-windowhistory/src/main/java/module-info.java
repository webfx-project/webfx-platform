// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.windowhistory {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.async;
    requires webfx.platform.json;
    requires webfx.platform.util;
    requires webfx.platform.windowlocation;

    // Exported packages
    exports dev.webfx.stack.platform.windowhistory;
    exports dev.webfx.stack.platform.windowhistory.spi;
    exports dev.webfx.stack.platform.windowhistory.spi.impl;

    // Used services
    uses dev.webfx.stack.platform.windowhistory.spi.WindowHistoryProvider;

}