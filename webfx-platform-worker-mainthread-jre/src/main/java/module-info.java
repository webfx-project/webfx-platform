// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java implementation (based in Java Threads) of the WebWorker API (for platforms other than the browser).
 */
module webfx.platform.worker.mainthread.jre {

    // Direct dependencies modules
    requires webfx.platform.console;
    requires webfx.platform.worker;
    requires webfx.platform.worker.mainthread;
    requires webfx.platform.worker.workerthread;
    requires webfx.platform.worker.workerthread.jre;

    // Exported packages
    exports dev.webfx.platform.worker.mainthead.spi.impl.jre;

    // Provided services
    provides dev.webfx.platform.worker.mainthread.spi.WorkerServiceProvider with dev.webfx.platform.worker.mainthead.spi.impl.jre.JreWorkerServiceProvider;

}