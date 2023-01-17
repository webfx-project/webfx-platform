// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.os {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.os;
    exports dev.webfx.platform.os.spi;
    exports dev.webfx.platform.os.spi.impl;

    // Used services
    uses dev.webfx.platform.os.spi.OSProvider;

}