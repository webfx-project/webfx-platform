// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.file {

    // Direct dependencies modules
    requires java.base;
    requires transitive webfx.platform.async;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.file;
    exports dev.webfx.platform.file.spi;

    // Used services
    uses dev.webfx.platform.file.spi.FileProvider;

}