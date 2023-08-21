// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation of the File API (for platforms other than the browser).
 */
module webfx.platform.file.java {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.async;
    requires webfx.platform.file;

    // Exported packages
    exports dev.webfx.platform.file.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.file.spi.BlobProvider with dev.webfx.platform.file.spi.impl.java.JavaBlobProvider;
    provides dev.webfx.platform.file.spi.FileProvider with dev.webfx.platform.file.spi.impl.java.JavaFileProvider;

}