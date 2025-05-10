// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * XML parser and formatter for AST objects.
 */
module webfx.platform.ast.xml.plugin {

    // Direct dependencies modules
    requires webfx.lib.javacupruntime;
    requires webfx.platform.ast;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.ast.xml;
    exports dev.webfx.platform.ast.xml.formatter;
    exports dev.webfx.platform.ast.xml.parser;
    exports dev.webfx.platform.ast.xml.parser.javacup;
    exports dev.webfx.platform.ast.xml.parser.jflex;

}