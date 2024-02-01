// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.ast.yaml {

    // Direct dependencies modules
    requires java.base;
    requires webfx.lib.javacupruntime;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.ast.yaml.formatter;
    exports dev.webfx.platform.ast.yaml.parser;
    exports dev.webfx.platform.ast.yaml.parser.javacup;
    exports dev.webfx.platform.ast.yaml.parser.jflex;

    // Provided services
    provides dev.webfx.platform.util.keyobject.formatter.spi.AstFormatterProvider with dev.webfx.platform.ast.yaml.formatter.YamlFormatterProvider;
    provides dev.webfx.platform.util.keyobject.parser.spi.AstParserProvider with dev.webfx.platform.ast.yaml.parser.YamlParserProvider;

}