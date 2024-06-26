// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * 
        Cross-platform Fetch API (mock of the Web Fetch API) for fetching remote resources such as Json web
        services (see {@link dev.webfx.platform.fetch.Fetch Fetch}).
    
 */
module webfx.platform.fetch {

    // Direct dependencies modules
    requires transitive webfx.platform.async;
    requires webfx.platform.blob;
    requires webfx.platform.service;

    // Exported packages
    exports dev.webfx.platform.fetch;
    exports dev.webfx.platform.fetch.spi;
    exports dev.webfx.platform.streams;

    // Used services
    uses dev.webfx.platform.fetch.spi.FetchProvider;

}