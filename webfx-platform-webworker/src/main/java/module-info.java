// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.webworker {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.stack.platform.webworker;
    exports dev.webfx.stack.platform.webworker.pool;
    exports dev.webfx.stack.platform.webworker.spi;
    exports dev.webfx.stack.platform.webworker.spi.base;

    // Used services
    uses dev.webfx.stack.platform.webworker.spi.WorkerServiceProvider;

}