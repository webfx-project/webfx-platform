// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.blob.java {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.blob;

    // Exported packages
    exports dev.webfx.platform.blob.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.blob.spi.BlobProvider with dev.webfx.platform.blob.spi.impl.java.JavaBlobProvider;

}