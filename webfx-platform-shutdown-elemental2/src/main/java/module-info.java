// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * GWT implementation of the Shutdown API (for the browser).
 */
module webfx.platform.shutdown.elemental2 {

    // Direct dependencies modules
    requires webfx.platform.polyfillcompat;
    requires webfx.platform.shutdown;
    requires elemental2.dom;

    // Exported packages
    exports dev.webfx.platform.shutdown.spi.impl.elemental2;

    // Provided services
    provides dev.webfx.platform.shutdown.spi.ShutdownProvider with dev.webfx.platform.shutdown.spi.impl.elemental2.Elemental2ShutdownProvider;

}