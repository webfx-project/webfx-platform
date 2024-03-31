// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.typedarray {

    // Direct dependencies modules
    requires webfx.platform.service;

    // Exported packages
    exports dev.webfx.platform.typedarray;
    exports dev.webfx.platform.typedarray.spi;

    // Used services
    uses dev.webfx.platform.typedarray.spi.TypedArrayFactoryProvider;

}