// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.useragent.gluon {

    // Direct dependencies modules
    requires webfx.platform.useragent;

    // Exported packages
    exports dev.webfx.platform.useragent.spi.impl.gluon;

    // Provided services
    provides dev.webfx.platform.useragent.spi.UserAgentProvider with dev.webfx.platform.useragent.spi.impl.gluon.GluonUserAgentProvider;

}