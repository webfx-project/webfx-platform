// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.webworker.java {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.console;
    requires webfx.platform.json;
    requires webfx.platform.uischeduler;
    requires webfx.platform.webworker;

    // Exported packages
    exports dev.webfx.platform.webworker.spi.impl.java;

    // Provided services
    provides dev.webfx.platform.webworker.spi.WorkerServiceProvider with dev.webfx.platform.webworker.spi.impl.java.JavaWorkerServiceProvider;

}