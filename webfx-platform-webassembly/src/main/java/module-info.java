// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform WebAssembly API for working with WebAssembly (see {@link dev.webfx.platform.webassembly.WebAssembly WebAssembly}).
 */
module webfx.platform.webassembly {

    // Direct dependencies modules
    requires webfx.platform.async;
    requires webfx.platform.service;

    // Exported packages
    exports dev.webfx.platform.webassembly;
    exports dev.webfx.platform.webassembly.spi;

    // Used services
    uses dev.webfx.platform.webassembly.spi.WebAssemblyProvider;

}