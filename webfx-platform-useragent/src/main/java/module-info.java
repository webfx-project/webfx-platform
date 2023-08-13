// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform API for user agent (see {@link dev.webfx.platform.useragent.UserAgent UserAgent})
 */
module webfx.platform.useragent {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.useragent;
    exports dev.webfx.platform.useragent.spi;
    exports dev.webfx.platform.useragent.spi.impl;

    // Used services
    uses dev.webfx.platform.useragent.spi.UserAgentProvider;

}