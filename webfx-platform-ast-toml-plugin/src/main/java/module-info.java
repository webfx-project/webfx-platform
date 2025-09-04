// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.ast.toml.plugin {

    // Direct dependencies modules
    requires webfx.lib.javacupruntime;
    requires webfx.platform.ast;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.ast.toml;
    exports dev.webfx.platform.ast.toml.formatter;
    exports dev.webfx.platform.ast.toml.parser;
    exports dev.webfx.platform.ast.toml.parser.javacup;
    exports dev.webfx.platform.ast.toml.parser.jflex;

    // Provided services
    provides dev.webfx.platform.ast.spi.formatter.AstFormatterProvider with dev.webfx.platform.ast.toml.formatter.TomlFormatterProvider;
    provides dev.webfx.platform.ast.spi.parser.AstParserProvider with dev.webfx.platform.ast.toml.parser.TomlParserProvider;

}