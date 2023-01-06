// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.storage.java {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.storage;
    requires webfx.platform.storagelocation;
    requires webfx.platform.visibility;

    // Exported packages
    exports dev.webfx.platform.storage.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.storage.spi.LocalStorageProvider with dev.webfx.platform.storage.spi.impl.java.JavaLocalStorageProvider;
    provides dev.webfx.platform.storage.spi.SessionStorageProvider with dev.webfx.platform.storage.spi.impl.java.JavaSessionStorageProvider;

}