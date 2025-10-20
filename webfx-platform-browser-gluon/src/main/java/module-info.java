// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.browser.gluon {

    // Direct dependencies modules
    requires com.gluonhq.attach.browser;
    requires webfx.platform.browser;
    requires webfx.platform.console;
    requires webfx.platform.scheduler;

    // Exported packages
    exports dev.webfx.platform.browser.spi.impl.gluon;

    // Provided services
    provides dev.webfx.platform.browser.spi.BrowserProvider with dev.webfx.platform.browser.spi.impl.gluon.GluonBrowserProvider;

}