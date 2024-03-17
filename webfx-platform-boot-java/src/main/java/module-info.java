// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation of the Boot API (for all platforms other than browser and server).
 */
module webfx.platform.boot.java {

    // Direct dependencies modules
    requires webfx.platform.boot;
    requires webfx.platform.reflect;

    // Exported packages
    exports dev.webfx.platform.boot.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.boot.spi.ApplicationBooterProvider with dev.webfx.platform.boot.spi.impl.java.JavaApplicationBooterProvider;

}