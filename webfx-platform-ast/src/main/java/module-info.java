// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.ast {

    // Direct dependencies modules
    requires webfx.platform.service;
    requires webfx.platform.util;
    requires webfx.platform.util.time;

    // Exported packages
    exports dev.webfx.platform.ast;
    exports dev.webfx.platform.ast.spi.factory;
    exports dev.webfx.platform.ast.spi.factory.nativeast;
    exports dev.webfx.platform.ast.spi.formatter;
    exports dev.webfx.platform.ast.spi.parser;
    exports dev.webfx.platform.ast.spi.parser.impl.properties;

    // Used services
    uses dev.webfx.platform.ast.spi.factory.AstFactoryProvider;
    uses dev.webfx.platform.ast.spi.formatter.AstFormatterProvider;
    uses dev.webfx.platform.ast.spi.parser.AstParserProvider;

}