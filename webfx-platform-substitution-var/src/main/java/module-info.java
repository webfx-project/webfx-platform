// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.substitution.var {

    // Direct dependencies modules
    requires webfx.platform.console;
    requires webfx.platform.substitution;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.substitution.spi.impl.var;
    exports dev.webfx.platform.substitution.var.spi;
    exports dev.webfx.platform.substitution.var.spi.impl;

    // Used services
    uses dev.webfx.platform.substitution.var.spi.VariablesResolver;

    // Provided services
    provides dev.webfx.platform.substitution.spi.SubstitutorProvider with dev.webfx.platform.substitution.spi.impl.var.VariablesSubstitutorProvider;

}