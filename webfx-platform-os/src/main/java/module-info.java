// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * 
        Cross-platform OS API for getting information about the host operating system
        (see {@link dev.webfx.platform.os.OperatingSystem OperatingSystem}).
    
 */
module webfx.platform.os {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.os;
    exports dev.webfx.platform.os.spi;
    exports dev.webfx.platform.os.spi.impl;

    // Used services
    uses dev.webfx.platform.os.spi.OperatingSystemProvider;

}