// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.typedarray.jre {

    // Direct dependencies modules
    requires webfx.platform.typedarray;

    // Exported packages
    exports dev.webfx.platform.typedarray.spi.impl.jre;

    // Provided services
    provides dev.webfx.platform.typedarray.spi.TypedArrayFactoryProvider with dev.webfx.platform.typedarray.spi.impl.jre.JreTypedArrayFactoryProvider;

}