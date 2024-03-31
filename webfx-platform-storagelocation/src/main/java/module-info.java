// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform StorageLocation API for locating application internal file storage (see {@link dev.webfx.platform.storagelocation.StorageLocation StorageLocation}). There is no GWT implementation because file storage is not supported by browsers. This API is mainly designed for mobiles and desktops.
 */
module webfx.platform.storagelocation {

    // Direct dependencies modules
    requires webfx.platform.service;

    // Exported packages
    exports dev.webfx.platform.storagelocation;
    exports dev.webfx.platform.storagelocation.spi;

    // Used services
    uses dev.webfx.platform.storagelocation.spi.StorageLocationProvider;

}