// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation of the OS API (for platforms other than browser and mobiles).
 */
module webfx.platform.os.jre {

    // Direct dependencies modules
    requires webfx.platform.os;

    // Exported packages
    exports dev.webfx.platform.os.spi.impl.jre;

    // Provided services
    provides dev.webfx.platform.os.spi.OperatingSystemProvider with dev.webfx.platform.os.spi.impl.jre.JreOperatingSystemProvider;

}