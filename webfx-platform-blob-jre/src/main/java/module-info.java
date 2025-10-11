// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.blob.jre {

    // Direct dependencies modules
    requires webfx.platform.blob;

    // Exported packages
    exports dev.webfx.platform.blob.spi.impl.jre;

    // Provided services
    provides dev.webfx.platform.blob.spi.BlobProvider with dev.webfx.platform.blob.spi.impl.jre.JreBlobProvider;

}