// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.substitution.var.windowlocation.plugin {

    // Direct dependencies modules
    requires webfx.platform.substitution.var;
    requires webfx.platform.windowlocation;

    // Exported packages
    exports dev.webfx.platform.substitution.var.spi.impl.windowlocation;

    // Provided services
    provides dev.webfx.platform.substitution.var.spi.VariablesResolver with dev.webfx.platform.substitution.var.spi.impl.windowlocation.WindowLocationVariablesResolver;

}