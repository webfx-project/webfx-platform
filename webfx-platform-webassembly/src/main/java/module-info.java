// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform API for working with WebAssembly (see {@link dev.webfx.platform.webassembly.WebAssembly WebAssembly}).
 */
module webfx.platform.webassembly {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.async;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.webassembly;
    exports dev.webfx.platform.webassembly.spi;

    // Used services
    uses dev.webfx.platform.webassembly.spi.WebAssemblyProvider;

}