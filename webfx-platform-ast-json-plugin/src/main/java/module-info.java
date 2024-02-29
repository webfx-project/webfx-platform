// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.ast.json.plugin {

    // Direct dependencies modules
    requires java.base;
    requires webfx.lib.javacupruntime;
    requires webfx.platform.ast;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.ast.json;
    exports dev.webfx.platform.ast.json.formatter;
    exports dev.webfx.platform.ast.json.parser;
    exports dev.webfx.platform.ast.json.parser.javacup;
    exports dev.webfx.platform.ast.json.parser.jflex;

    // Provided services
    provides dev.webfx.platform.ast.spi.formatter.AstFormatterProvider with dev.webfx.platform.ast.json.formatter.JsonFormatterProvider;
    provides dev.webfx.platform.ast.spi.parser.AstParserProvider with dev.webfx.platform.ast.json.parser.JsonParserProvider;

}