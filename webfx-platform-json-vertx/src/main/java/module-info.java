// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.json.vertx {

    // Direct dependencies modules
    requires io.vertx.core;
    requires java.base;
    requires webfx.platform.json;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.json.spi.impl.vertx;

    // Provided services
    provides dev.webfx.platform.json.spi.JsonProvider with dev.webfx.platform.json.spi.impl.vertx.VertxJsonObject;

}