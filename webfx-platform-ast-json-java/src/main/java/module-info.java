// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation of the Json API (for platforms other than browser and server).
 */
module webfx.platform.ast.json.java {

    // Direct dependencies modules
    requires webfx.platform.ast.json;

    // Exported packages
    exports dev.webfx.platform.ast.json.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.ast.json.spi.JsonProvider with dev.webfx.platform.ast.json.spi.impl.java.JavaJsonProvider;

}