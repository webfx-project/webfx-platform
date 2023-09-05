// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Vert.x implementation of the Json API (for the server).
 */
module webfx.platform.ast.json.vertx {

    // Direct dependencies modules
    requires io.vertx.core;
    requires java.base;
    requires webfx.platform.ast.json;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.ast.json.spi.impl.vertx;

    // Provided services
    provides dev.webfx.platform.ast.json.spi.JsonProvider with dev.webfx.platform.ast.json.spi.impl.vertx.VertxJsonObject;

}