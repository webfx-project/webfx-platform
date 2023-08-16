// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java server-side implementation of the UserAgent API (for servers).
 */
module webfx.platform.useragent.java.server {

    // Direct dependencies modules
    requires webfx.platform.useragent;

    // Exported packages
    exports dev.webfx.platform.useragent.spi.impl.java.server;

    // Provided services
    provides dev.webfx.platform.useragent.spi.UserAgentProvider with dev.webfx.platform.useragent.spi.impl.java.server.JavaServerUserAgentProvider;

}