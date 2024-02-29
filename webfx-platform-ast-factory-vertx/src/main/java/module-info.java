// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.ast.factory.vertx {

    // Direct dependencies modules
    requires io.vertx.core;
    requires java.base;
    requires webfx.platform.ast;
    requires webfx.platform.ast.factory.generic;

    // Exported packages
    exports dev.webfx.platform.ast.spi.factory.impl.vertx;

    // Provided services
    provides dev.webfx.platform.ast.spi.factory.AstFactoryProvider with dev.webfx.platform.ast.spi.factory.impl.vertx.VertxAstFactoryProvider;

}