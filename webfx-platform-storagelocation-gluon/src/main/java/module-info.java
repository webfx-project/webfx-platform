// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.storagelocation.gluon {

    // Direct dependencies modules
    requires com.gluonhq.attach.storage;
    requires com.gluonhq.attach.util;
    requires webfx.platform.storagelocation;

    // Exported packages
    exports dev.webfx.platform.storagelocation.spi.impl.gluon;

    // Provided services
    provides dev.webfx.platform.storagelocation.spi.StorageLocationProvider with dev.webfx.platform.storagelocation.spi.impl.gluon.GluonStorageLocationProvider;

}