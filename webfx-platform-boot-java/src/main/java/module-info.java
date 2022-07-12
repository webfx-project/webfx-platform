// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.boot.java {

    // Direct dependencies modules
    requires webfx.platform.boot;

    // Exported packages
    exports dev.webfx.platform.boot.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.boot.spi.ApplicationBooterProvider with dev.webfx.platform.boot.spi.impl.java.JavaApplicationBooterProvider;

}