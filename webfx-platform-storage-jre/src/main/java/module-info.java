// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation of the Storage API (for platforms other than the browser).
 */
module webfx.platform.storage.jre {

    // Direct dependencies modules
    requires webfx.platform.console;
    requires webfx.platform.scheduler;
    requires webfx.platform.storage;
    requires webfx.platform.storagelocation;
    requires webfx.platform.visibility;

    // Exported packages
    exports dev.webfx.platform.storage.spi.impl.jre;

    // Provided services
    provides dev.webfx.platform.storage.spi.LocalStorageProvider with dev.webfx.platform.storage.spi.impl.jre.JreLocalStorageProvider;
    provides dev.webfx.platform.storage.spi.SessionStorageProvider with dev.webfx.platform.storage.spi.impl.jre.JreSessionStorageProvider;

}