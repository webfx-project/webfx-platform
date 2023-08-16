// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation of the Console API (for all platforms other than browser).
 */
module webfx.platform.console.java {

    // Direct dependencies modules
    requires webfx.platform.console;

    // Exported packages
    exports dev.webfx.platform.console.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.console.spi.ConsoleProvider with dev.webfx.platform.console.spi.impl.java.JavaConsoleProvider;

}