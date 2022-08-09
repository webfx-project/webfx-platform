// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.json.java {

    // Direct dependencies modules
    requires webfx.platform.json;

    // Exported packages
    exports dev.webfx.platform.json.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.json.spi.JsonProvider with dev.webfx.platform.json.spi.impl.java.JavaJsonProvider;

}