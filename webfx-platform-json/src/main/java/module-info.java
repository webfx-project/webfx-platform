// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform Json API (see {@link dev.webfx.platform.json.Json Json}).
 */
module webfx.platform.json {

    // Direct dependencies modules
    requires java.base;
    requires webfx.lib.javacupruntime;
    requires webfx.platform.ast;
    requires transitive webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.json;
    exports dev.webfx.platform.json.parser;
    exports dev.webfx.platform.json.parser.javacup;
    exports dev.webfx.platform.json.parser.jflex;
    exports dev.webfx.platform.json.spi;
    exports dev.webfx.platform.json.spi.impl.listmap;
    exports dev.webfx.platform.json.tree;

    // Used services
    uses dev.webfx.platform.json.spi.JsonProvider;

    // Provided services
    provides dev.webfx.platform.ast.formatter.spi.AstFormatterProvider with dev.webfx.platform.json.tree.JsonTreeFormatterProvider;
    provides dev.webfx.platform.ast.parser.spi.AstParserProvider with dev.webfx.platform.json.tree.JsonAstParserProvider;

}