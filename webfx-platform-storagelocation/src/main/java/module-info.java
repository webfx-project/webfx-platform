// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform API for locating application storage (see {@link dev.webfx.platform.storagelocation.StorageLocation StorageLocation}).
 */
module webfx.platform.storagelocation {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.storagelocation;
    exports dev.webfx.platform.storagelocation.spi;

    // Used services
    uses dev.webfx.platform.storagelocation.spi.StorageLocationProvider;

}