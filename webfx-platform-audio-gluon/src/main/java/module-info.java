// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Gluon implementation of the Audio API (for mobiles).
 */
module webfx.platform.audio.gluon {

    // Direct dependencies modules
    requires com.gluonhq.attach.audio;
    requires webfx.platform.audio;
    requires webfx.platform.console;
    requires webfx.platform.scheduler;

    // Exported packages
    exports dev.webfx.platform.audio.spi.impl.gluon;

    // Provided services
    provides dev.webfx.platform.audio.spi.AudioServiceProvider with dev.webfx.platform.audio.spi.impl.gluon.GluonAudioServiceProvider;

}