// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform Json API (see {@link dev.webfx.platform.ast.json.Json Json}).
 */
module webfx.platform.ast.json {

    // Direct dependencies modules
    requires java.base;
    requires webfx.lib.javacupruntime;
    requires webfx.platform.ast;
    requires transitive webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.ast.json;
    exports dev.webfx.platform.ast.json.parser;
    exports dev.webfx.platform.ast.json.parser.javacup;
    exports dev.webfx.platform.ast.json.parser.jflex;
    exports dev.webfx.platform.ast.json.spi;
    exports dev.webfx.platform.ast.json.spi.impl.listmap;

    // Used services
    uses dev.webfx.platform.ast.json.spi.JsonProvider;

    // Provided services
    provides dev.webfx.platform.ast.formatter.spi.AstFormatterProvider with dev.webfx.platform.ast.json.JsonFormatterProvider;
    provides dev.webfx.platform.ast.parser.spi.AstParserProvider with dev.webfx.platform.ast.json.JsonAstParserProvider;

}