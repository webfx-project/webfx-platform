// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation of the File API (for platforms other than the browser).
 */
module webfx.platform.file.jre {

    // Direct dependencies modules
    requires webfx.platform.async;
    requires webfx.platform.blob.jre;
    requires webfx.platform.file;

    // Exported packages
    exports dev.webfx.platform.file.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.file.spi.FileProvider with dev.webfx.platform.file.spi.impl.java.JavaFileProvider;

}