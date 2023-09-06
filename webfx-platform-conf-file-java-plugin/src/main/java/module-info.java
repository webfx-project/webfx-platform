// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.conf.file.java.plugin {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.async;
    requires webfx.platform.conf;

    // Exported packages
    exports dev.webfx.platform.conf.spi.impl.file.java;

    // Provided services
    provides dev.webfx.platform.conf.spi.ConfigLoaderProvider with dev.webfx.platform.conf.spi.impl.file.java.JavaFileConfigLoader;

}