// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform Arch API which provides information about the platform architecture (see {@link dev.webfx.platform.arch.Arch Arch}).
 */
module webfx.platform.arch {

    // Direct dependencies modules
    requires webfx.platform.service;

    // Exported packages
    exports dev.webfx.platform.arch;
    exports dev.webfx.platform.arch.spi;
    exports dev.webfx.platform.arch.spi.impl.web;

    // Used services
    uses dev.webfx.platform.arch.spi.ArchProvider;

}