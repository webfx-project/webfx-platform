// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.os.gluon {

    // Direct dependencies modules
    requires com.gluonhq.attach.util;
    requires webfx.platform.os;

    // Exported packages
    exports dev.webfx.platform.os.spi.impl.gluon;

    // Provided services
    provides dev.webfx.platform.os.spi.OperatingSystemProvider with dev.webfx.platform.os.spi.impl.gluon.GluonOperatingSystemProvider;

}