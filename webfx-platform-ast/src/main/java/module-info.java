// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.ast {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.ast;
    exports dev.webfx.platform.ast.formatter;
    exports dev.webfx.platform.ast.formatter.spi;
    exports dev.webfx.platform.ast.impl;
    exports dev.webfx.platform.ast.impl.listmap;
    exports dev.webfx.platform.ast.parser;
    exports dev.webfx.platform.ast.parser.spi;
    exports dev.webfx.platform.ast.parser.spi.impl.properties;

    // Used services
    uses dev.webfx.platform.ast.formatter.spi.AstFormatterProvider;
    uses dev.webfx.platform.ast.parser.spi.AstParserProvider;

}