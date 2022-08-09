// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.json {

    // Direct dependencies modules
    requires java.base;
    requires webfx.lib.javacupruntime;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.stack.platform.json;
    exports dev.webfx.stack.platform.json.parser;
    exports dev.webfx.stack.platform.json.parser.javacup;
    exports dev.webfx.stack.platform.json.parser.jflex;
    exports dev.webfx.stack.platform.json.spi;
    exports dev.webfx.stack.platform.json.spi.impl.listmap;

    // Used services
    uses dev.webfx.stack.platform.json.spi.JsonProvider;

}