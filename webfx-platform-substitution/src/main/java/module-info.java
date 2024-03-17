// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.substitution {

    // Direct dependencies modules
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.substitution;
    exports dev.webfx.platform.substitution.spi;

    // Used services
    uses dev.webfx.platform.substitution.spi.SubstitutorProvider;

}