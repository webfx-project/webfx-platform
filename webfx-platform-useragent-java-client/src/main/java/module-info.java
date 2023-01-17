// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.useragent.java.client {

    // Direct dependencies modules
    requires webfx.platform.useragent;

    // Exported packages
    exports dev.webfx.platform.useragent.spi.impl.java.client;

    // Provided services
    provides dev.webfx.platform.useragent.spi.UserAgentProvider with dev.webfx.platform.useragent.spi.impl.java.client.JavaClientUserAgentProvider;

}