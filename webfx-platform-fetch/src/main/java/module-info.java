// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.fetch {

    // Direct dependencies modules
    requires java.base;
    requires transitive webfx.platform.async;
    requires webfx.platform.file;
    requires transitive webfx.platform.json;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.fetch;
    exports dev.webfx.platform.fetch.spi;
    exports dev.webfx.platform.streams;

    // Used services
    uses dev.webfx.platform.fetch.spi.FetchProvider;

}