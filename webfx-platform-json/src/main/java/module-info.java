// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.json {

    // Direct dependencies modules
    requires java.base;
    requires webfx.lib.javacupruntime;
    requires transitive webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.json;
    exports dev.webfx.platform.json.parser;
    exports dev.webfx.platform.json.parser.javacup;
    exports dev.webfx.platform.json.parser.jflex;
    exports dev.webfx.platform.json.spi;
    exports dev.webfx.platform.json.spi.impl.listmap;

    // Used services
    uses dev.webfx.platform.json.spi.JsonProvider;

}