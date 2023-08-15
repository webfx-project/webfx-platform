// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform API for getting information about the host architecture (see {@link dev.webfx.platform.arch.Arch Arch}).
 */
module webfx.platform.arch {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.arch;
    exports dev.webfx.platform.arch.spi;

    // Used services
    uses dev.webfx.platform.arch.spi.ArchProvider;

}