// File managed by WebFX (DO NOT EDIT MANUALLY)

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