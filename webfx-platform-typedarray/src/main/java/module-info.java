// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.typedarray {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.typedarray;
    exports dev.webfx.platform.typedarray.spi;

    // Used services
    uses dev.webfx.platform.typedarray.spi.TypedArrayFactoryProvider;

}