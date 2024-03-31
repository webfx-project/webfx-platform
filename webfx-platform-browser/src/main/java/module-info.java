// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.browser {

    // Direct dependencies modules
    requires webfx.platform.service;

    // Exported packages
    exports dev.webfx.platform.browser;
    exports dev.webfx.platform.browser.spi;

    // Used services
    uses dev.webfx.platform.browser.spi.BrowserProvider;

}