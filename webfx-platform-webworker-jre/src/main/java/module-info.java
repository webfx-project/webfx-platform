// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation (based in Java Threads) of the WebWorker API (for platforms other than the browser).
 */
module webfx.platform.webworker.jre {

    // Direct dependencies modules
    requires webfx.platform.ast;
    requires webfx.platform.console;
    requires webfx.platform.scheduler;
    requires webfx.platform.webworker;

    // Exported packages
    exports dev.webfx.platform.webworker.spi.impl.jre;

    // Provided services
    provides dev.webfx.platform.webworker.spi.WorkerServiceProvider with dev.webfx.platform.webworker.spi.impl.jre.JreWorkerServiceProvider;

}