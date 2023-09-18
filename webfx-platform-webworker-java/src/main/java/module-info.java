// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation (based in Java Threads) of the WebWorker API (for platforms other than the browser).
 */
module webfx.platform.webworker.java {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.ast;
    requires webfx.platform.console;
    requires webfx.platform.uischeduler;
    requires webfx.platform.webworker;

    // Exported packages
    exports dev.webfx.platform.webworker.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.webworker.spi.WorkerServiceProvider with dev.webfx.platform.webworker.spi.impl.java.JavaWorkerServiceProvider;

}