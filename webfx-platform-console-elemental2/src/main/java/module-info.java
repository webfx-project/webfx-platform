// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * GWT implementation of the Console API (for the browser).
 */
module webfx.platform.console.elemental2 {

    // Direct dependencies modules
    requires elemental2.dom;
    requires webfx.platform.console;

    // Exported packages
    exports dev.webfx.platform.console.spi.impl.gwtj2cl;

    // Provided services
    provides dev.webfx.platform.console.spi.ConsoleProvider with dev.webfx.platform.console.spi.impl.gwtj2cl.GwtJ2clConsoleProvider;

}