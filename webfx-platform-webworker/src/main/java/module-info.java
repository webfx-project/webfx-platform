// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.webworker {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.webworker;
    exports dev.webfx.platform.webworker.pool;
    exports dev.webfx.platform.webworker.spi;
    exports dev.webfx.platform.webworker.spi.base;

    // Used services
    uses dev.webfx.platform.webworker.spi.WorkerServiceProvider;

}