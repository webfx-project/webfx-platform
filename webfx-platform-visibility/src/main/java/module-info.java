// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform Visibility API to know and react to the application visibility state (see {@link dev.webfx.platform.visibility.Visibility Visibility}).
 */
module webfx.platform.visibility {

    // Direct dependencies modules
    requires webfx.platform.service;

    // Exported packages
    exports dev.webfx.platform.visibility;
    exports dev.webfx.platform.visibility.spi;
    exports dev.webfx.platform.visibility.spi.impl;

    // Used services
    uses dev.webfx.platform.visibility.spi.VisibilityProvider;

}