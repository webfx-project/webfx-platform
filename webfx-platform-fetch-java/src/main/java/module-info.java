// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation of the Fetch API (for platforms other than browser and server).
 */
module webfx.platform.fetch.java {

    // Direct dependencies modules
    requires java.net.http;
    requires webfx.platform.async;
    requires webfx.platform.blob;
    requires webfx.platform.blob.java;
    requires webfx.platform.fetch;
    requires webfx.platform.scheduler;
    requires webfx.platform.scheduler.java;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.fetch.spi.impl.java;
    exports dev.webfx.platform.streams.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.fetch.spi.FetchProvider with dev.webfx.platform.fetch.spi.impl.java.JavaFetchProvider;

}