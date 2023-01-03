// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.storagelocation.java {

    // Direct dependencies modules
    requires com.gluonhq.attach.storage;
    requires com.gluonhq.attach.util;
    requires java.base;
    requires javafx.graphics;
    requires webfx.platform.storagelocation;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.storagelocation.spi.impl.java;

    // Used services
    uses javafx.application.Application;

    // Provided services
    provides dev.webfx.platform.storagelocation.spi.StorageLocationProvider with dev.webfx.platform.storagelocation.spi.impl.java.JavaStorageLocationProvider;

}