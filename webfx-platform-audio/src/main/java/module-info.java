// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * 
        Cross-platform Audio API.
        Most users will use the JavaFX Media API instead, which runs on desktops (via OpenJFX) and in the browser
        (via a GWT implementation provided by the WebFX Kit). Gluon doesn't support the JavaFX Media API, but the WebFX
        Kit does (for the audio) through mapping the JavaFX Media API to this Audio API (which has a Gluon implementation).
        A backward mapping is also supported for WebFX applications that may use this Audio API directly: in this case,
        the WebFX Kit will map this Audio API back to the JavaFX Media API for platforms other than mobiles.
    
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