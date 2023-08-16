// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform UserAgent API for getting information about the user agent (see {@link dev.webfx.platform.useragent.UserAgent UserAgent}).
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