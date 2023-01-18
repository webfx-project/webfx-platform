// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.os.java {

    // Direct dependencies modules
    requires webfx.platform.os;

    // Exported packages
    exports dev.webfx.platform.os.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.os.spi.OperatingSystemProvider with dev.webfx.platform.os.spi.impl.java.JavaOperatingSystemProvider;

}