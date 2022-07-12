// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.storage {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.storage;
    exports dev.webfx.platform.storage.spi;

    // Used services
    uses dev.webfx.platform.storage.spi.LocalStorageProvider;
    uses dev.webfx.platform.storage.spi.SessionStorageProvider;

}