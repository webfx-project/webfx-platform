// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Gluon implementation of the StorageLocation API (for mobiles).
 */
module webfx.platform.storagelocation.gluon {

    // Direct dependencies modules
    requires com.gluonhq.attach.storage;
    requires webfx.platform.console;
    requires webfx.platform.storagelocation;
    requires webfx.platform.uischeduler;

    // Exported packages
    exports dev.webfx.platform.storagelocation.spi.impl.gluon;

    // Provided services
    provides dev.webfx.platform.storagelocation.spi.StorageLocationProvider with dev.webfx.platform.storagelocation.spi.impl.gluon.GluonStorageLocationProvider;

}