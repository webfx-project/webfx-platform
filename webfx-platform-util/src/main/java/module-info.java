// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * A set of utility classes.
 */
module webfx.platform.util {

    // Direct dependencies modules
    requires java.base;
    requires java.logging;

    // Exported packages
    exports dev.webfx.platform.util;
    exports dev.webfx.platform.util.collection;
    exports dev.webfx.platform.util.function;
    exports dev.webfx.platform.util.keyobject;
    exports dev.webfx.platform.util.keyobject.formatter;
    exports dev.webfx.platform.util.keyobject.formatter.spi;
    exports dev.webfx.platform.util.keyobject.impl;
    exports dev.webfx.platform.util.keyobject.impl.listmap;
    exports dev.webfx.platform.util.keyobject.parser;
    exports dev.webfx.platform.util.keyobject.parser.spi;
    exports dev.webfx.platform.util.keyobject.parser.spi.impl.properties;
    exports dev.webfx.platform.util.serviceloader;
    exports dev.webfx.platform.util.tuples;
    exports dev.webfx.platform.util.uuid;

    // Used services
    uses dev.webfx.platform.util.keyobject.formatter.spi.AstFormatterProvider;
    uses dev.webfx.platform.util.keyobject.parser.spi.AstParserProvider;

}