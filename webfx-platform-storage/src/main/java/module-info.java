// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform API for client-side storage  (see {@link dev.webfx.platform.storage.LocalStorage LocalStorage} &amp; {@link dev.webfx.platform.storage.SessionStorage SessionStorage})
 */
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