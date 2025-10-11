// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation of the Fetch API (for platforms other than browser and server).
 */
module webfx.platform.fetch.jre {

    // Direct dependencies modules
    requires java.net.http;
    requires webfx.platform.async;
    requires webfx.platform.blob;
    requires webfx.platform.blob.jre;
    requires webfx.platform.fetch;
    requires webfx.platform.scheduler;
    requires webfx.platform.scheduler.jre;
    requires webfx.platform.util;
    requires webfx.platform.util.http;

    // Exported packages
    exports dev.webfx.platform.fetch.spi.impl.jre;
    exports dev.webfx.platform.streams.spi.impl.jre;

    // Provided services
    provides dev.webfx.platform.fetch.spi.FetchProvider with dev.webfx.platform.fetch.spi.impl.jre.JreFetchProvider;

}