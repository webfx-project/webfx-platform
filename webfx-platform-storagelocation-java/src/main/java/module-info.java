// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.storagelocation.java {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.meta;
    requires webfx.platform.storagelocation;

    // Exported packages
    exports dev.webfx.platform.storagelocation.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.storagelocation.spi.StorageLocationProvider with dev.webfx.platform.storagelocation.spi.impl.java.JavaStorageLocationProvider;

}