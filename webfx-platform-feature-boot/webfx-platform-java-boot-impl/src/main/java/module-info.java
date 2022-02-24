// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.java.boot.impl {

    // Direct dependencies modules
    requires webfx.platform.shared.boot;

    // Exported packages
    exports dev.webfx.platform.java.services.boot.spi.impl;

    // Provided services
    provides dev.webfx.platform.shared.services.boot.spi.ApplicationBooterProvider with dev.webfx.platform.java.services.boot.spi.impl.JavaApplicationBooterProvider;

}