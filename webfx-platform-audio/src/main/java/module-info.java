// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Cross-platform API for playing audio (see {@link dev.webfx.platform.audio.AudioService AudioService})
 */
module webfx.platform.audio {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.audio;
    exports dev.webfx.platform.audio.spi;

    // Used services
    uses dev.webfx.platform.audio.spi.AudioServiceProvider;

}