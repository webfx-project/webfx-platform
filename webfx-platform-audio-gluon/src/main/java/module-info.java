// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.audio.gluon {

    // Direct dependencies modules
    requires com.gluonhq.attach.audio;
    requires java.base;
    requires webfx.platform.audio;
    requires webfx.platform.console;

    // Exported packages
    exports dev.webfx.platform.audio.spi.impl.gluon;

    // Provided services
    provides dev.webfx.platform.audio.spi.AudioServiceProvider with dev.webfx.platform.audio.spi.impl.gluon.GluonAudioServiceProvider;

}