// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.console {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.console;
    exports dev.webfx.platform.console.spi;

    // Used services
    uses dev.webfx.platform.console.spi.ConsoleProvider;

}