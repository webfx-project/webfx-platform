// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * 
        Cross-platform API &amp; SPI for booting WebFX applications. It defines a single entry point for all
        WebFX applications (see {@link dev.webfx.platform.boot.ApplicationBooter ApplicationBooter}) and
        sequences the application boot. If necessary, an application module such as a plugin module can be called
        during the boot sequence by implementing the SPI
        (see {@link dev.webfx.platform.boot.spi.ApplicationModuleBooter ApplicationModuleBooter}).
        An alternative SPI allows WebFX applications to start jobs at the end of the boot sequence
        (see {@link dev.webfx.platform.boot.spi.ApplicationJob ApplicationJob}).
    
 */
module webfx.platform.boot {

    // Direct dependencies modules
    requires webfx.platform.console;
    requires webfx.platform.meta;
    requires webfx.platform.service;
    requires webfx.platform.shutdown;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.boot;
    exports dev.webfx.platform.boot.spi;
    exports dev.webfx.platform.boot.spi.impl;

    // Used services
    uses dev.webfx.platform.boot.spi.ApplicationBooterProvider;
    uses dev.webfx.platform.boot.spi.ApplicationJob;
    uses dev.webfx.platform.boot.spi.ApplicationModuleBooter;

    // Provided services
    provides dev.webfx.platform.boot.spi.ApplicationModuleBooter with dev.webfx.platform.boot.spi.impl.ApplicationJobsInitializer, dev.webfx.platform.boot.spi.impl.ApplicationJobsStarter;

}