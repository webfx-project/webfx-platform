// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.client.storage {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.shared.util;

    // Exported packages
    exports dev.webfx.platform.client.services.storage;
    exports dev.webfx.platform.client.services.storage.spi;

    // Used services
    uses dev.webfx.platform.client.services.storage.spi.LocalStorageProvider;
    uses dev.webfx.platform.client.services.storage.spi.SessionStorageProvider;

}