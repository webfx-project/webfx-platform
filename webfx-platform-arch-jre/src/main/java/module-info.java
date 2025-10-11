// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation of the Arch API (for all platforms other than browser).
 */
module webfx.platform.arch.jre {

    // Direct dependencies modules
    requires webfx.platform.arch;

    // Exported packages
    exports dev.webfx.platform.arch.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.arch.spi.ArchProvider with dev.webfx.platform.arch.spi.impl.java.JavaArchProvider;

}