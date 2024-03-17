// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.ast.factory.generic {

    // Direct dependencies modules
    requires webfx.platform.ast;

    // Exported packages
    exports dev.webfx.platform.ast.spi.factory.impl.generic;

    // Provided services
    provides dev.webfx.platform.ast.spi.factory.AstFactoryProvider with dev.webfx.platform.ast.spi.factory.impl.generic.GenericAstFactoryProvider;

}