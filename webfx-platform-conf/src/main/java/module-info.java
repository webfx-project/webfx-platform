// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.conf {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.async;
    requires webfx.platform.resource;
    requires webfx.platform.substitution;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.conf;
    exports dev.webfx.platform.conf.impl;
    exports dev.webfx.platform.conf.spi;

    // Used services
    uses dev.webfx.platform.conf.spi.ConfigLoaderProvider;

}