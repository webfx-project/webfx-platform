// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.fetch.java {

    // Direct dependencies modules
    requires java.net.http;
    requires webfx.platform.async;
    requires webfx.platform.fetch;
    requires webfx.platform.file;
    requires webfx.platform.file.java;
    requires webfx.platform.json;
    requires webfx.platform.scheduler;
    requires webfx.platform.scheduler.java;

    // Exported packages
    exports dev.webfx.platform.fetch.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.fetch.spi.FetchProvider with dev.webfx.platform.fetch.spi.impl.java.JavaFetchProvider;

}