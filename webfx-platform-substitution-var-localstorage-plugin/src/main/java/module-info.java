// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.substitution.var.localstorage.plugin {

    // Direct dependencies modules
    requires webfx.platform.storage;
    requires webfx.platform.substitution.var;

    // Exported packages
    exports dev.webfx.platform.substitution.var.spi.impl.localstorage;

    // Provided services
    provides dev.webfx.platform.substitution.var.spi.VariablesResolver with dev.webfx.platform.substitution.var.spi.impl.localstorage.LocalStorageVariablesResolver;

}