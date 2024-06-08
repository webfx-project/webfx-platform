// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Vert.x implementation of the Fetch API (for the server).
 */
module webfx.platform.fetch.vertx {

    // Direct dependencies modules
    requires io.vertx.core;
    requires io.vertx.web.client;
    requires io.vertx.web.common;
    requires webfx.platform.async;
    requires webfx.platform.blob;
    requires webfx.platform.fetch;
    requires webfx.platform.file.java;
    requires webfx.platform.util;
    requires webfx.platform.vertx.common;

    // Exported packages
    exports dev.webfx.platform.fetch.spi.impl.vertx;

    // Provided services
    provides dev.webfx.platform.fetch.spi.FetchProvider with dev.webfx.platform.fetch.spi.impl.vertx.VertxFetchProvider;

}