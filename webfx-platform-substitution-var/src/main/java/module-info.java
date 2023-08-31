// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.substitution.var {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.console;
    requires webfx.platform.substitution;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.substitution.spi.impl.var;
    exports dev.webfx.platform.substitution.var.spi;

    // Used services
    uses dev.webfx.platform.substitution.var.spi.VariablesResolver;

    // Provided services
    provides dev.webfx.platform.substitution.spi.SubstitutorProvider with dev.webfx.platform.substitution.spi.impl.var.VariablesSubstitutorProvider;

}