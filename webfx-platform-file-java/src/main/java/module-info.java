// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.file.java {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.async;
    requires webfx.platform.file;

    // Exported packages
    exports dev.webfx.platform.file.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.file.spi.FileProvider with dev.webfx.platform.file.spi.impl.java.JavaFileProvider;

}