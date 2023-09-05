// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform WindowHistory API for accessing the window history (see {@link dev.webfx.platform.windowhistory.WindowHistory WindowHistory}).
 */
module webfx.platform.windowhistory {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.ast.json.plugin;
    requires webfx.platform.async;
    requires webfx.platform.util;
    requires webfx.platform.windowlocation;

    // Exported packages
    exports dev.webfx.platform.windowhistory;
    exports dev.webfx.platform.windowhistory.spi;
    exports dev.webfx.platform.windowhistory.spi.impl;

    // Used services
    uses dev.webfx.platform.windowhistory.spi.WindowHistoryProvider;

}