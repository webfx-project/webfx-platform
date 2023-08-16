// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Vert.x implementation of the Boot API (for the server).
 */
module webfx.platform.boot.vertx {

    // Direct dependencies modules
    requires io.vertx.core;
    requires java.base;
    requires webfx.platform.boot;
    requires webfx.platform.shutdown;
    requires webfx.platform.vertx.common;

    // Exported packages
    exports dev.webfx.platform.boot.spi.impl.vertx;

    // Provided services
    provides dev.webfx.platform.boot.spi.ApplicationBooterProvider with dev.webfx.platform.boot.spi.impl.vertx.VertxApplicationBooterVerticle;

}