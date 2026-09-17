// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Resolves opt-in configuration variables (ex: a database password) by asking the developer to type them at startup, so they don't have to be stored on disk.
 */
module webfx.platform.substitution.var.prompt.jre.plugin {

    // Direct dependencies modules
    requires webfx.platform.conf;
    requires webfx.platform.console;
    requires webfx.platform.secret.jre;
    requires webfx.platform.substitution.var;

    // Exported packages
    exports dev.webfx.platform.substitution.var.spi.impl.prompt;

    // Provided services
    provides dev.webfx.platform.substitution.var.spi.VariablesResolver with dev.webfx.platform.substitution.var.spi.impl.prompt.PromptVariablesResolver;

}