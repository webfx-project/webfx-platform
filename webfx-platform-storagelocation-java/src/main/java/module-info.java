// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation of the StorageLocation API (for platforms other than mobiles &amp; browser).
 */
module webfx.platform.storagelocation.java {

    // Direct dependencies modules
    requires webfx.platform.meta;
    requires webfx.platform.storagelocation;

    // Exported packages
    exports dev.webfx.platform.storagelocation.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.storagelocation.spi.StorageLocationProvider with dev.webfx.platform.storagelocation.spi.impl.java.JavaStorageLocationProvider;

}