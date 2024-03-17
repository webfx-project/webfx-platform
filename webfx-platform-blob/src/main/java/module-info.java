// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.blob {

    // Direct dependencies modules
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.blob;
    exports dev.webfx.platform.blob.spi;

    // Used services
    uses dev.webfx.platform.blob.spi.BlobProvider;

}