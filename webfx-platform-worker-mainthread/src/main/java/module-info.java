// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.worker.mainthread {

    // Direct dependencies modules
    requires webfx.platform.service;
    requires webfx.platform.worker;

    // Exported packages
    exports dev.webfx.platform.worker.mainthread;
    exports dev.webfx.platform.worker.mainthread.spi;

    // Used services
    uses dev.webfx.platform.worker.mainthread.spi.WorkerServiceProvider;

}