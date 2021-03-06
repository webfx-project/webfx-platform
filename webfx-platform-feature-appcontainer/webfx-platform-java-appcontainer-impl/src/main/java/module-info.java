// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.java.appcontainer.impl {

    // Direct dependencies modules
    requires webfx.platform.shared.appcontainer;

    // Exported packages
    exports dev.webfx.platform.java.services.appcontainer.spi.impl;

    // Provided services
    provides dev.webfx.platform.shared.services.appcontainer.spi.ApplicationContainerProvider with dev.webfx.platform.java.services.appcontainer.spi.impl.JavaApplicationContainerProvider;

}