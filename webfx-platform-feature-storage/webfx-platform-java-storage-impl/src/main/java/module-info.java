// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.java.storage.impl {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.client.storage;

    // Exported packages
    exports dev.webfx.platform.java.services.storage.spi.impl;

    // Provided services
    provides dev.webfx.platform.client.services.storage.spi.LocalStorageProvider with dev.webfx.platform.java.services.storage.spi.impl.JavaLocalStorageProvider;
    provides dev.webfx.platform.client.services.storage.spi.SessionStorageProvider with dev.webfx.platform.java.services.storage.spi.impl.JavaSessionStorageProvider;

}