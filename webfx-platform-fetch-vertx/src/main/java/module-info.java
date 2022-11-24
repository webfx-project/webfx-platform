// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.fetch.vertx {

    // Direct dependencies modules
    requires io.vertx.core;
    requires java.base;
    requires webfx.platform.async;
    requires webfx.platform.fetch;
    requires webfx.platform.file;
    requires webfx.platform.json;
    requires webfx.platform.vertx.common;

    // Exported packages
    exports dev.webfx.platform.fetch.spi.impl.vertx;

    // Provided services
    provides dev.webfx.platform.fetch.spi.FetchProvider with dev.webfx.platform.fetch.spi.impl.vertx.VertxFetchProvider;

}