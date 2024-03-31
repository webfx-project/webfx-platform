// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform API for logging in the console (see {@link dev.webfx.platform.console.Console Console}).
 */
module webfx.platform.console {

    // Direct dependencies modules
    requires webfx.platform.service;

    // Exported packages
    exports dev.webfx.platform.console;
    exports dev.webfx.platform.console.spi;

    // Used services
    uses dev.webfx.platform.console.spi.ConsoleProvider;

}