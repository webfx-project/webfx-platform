// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Java headless implementation of the Visibility API.
 */
module webfx.platform.visibility.jre.headless {

    // Direct dependencies modules
    requires webfx.platform.boot;
    requires webfx.platform.visibility;

    // Exported packages
    exports dev.webfx.platform.visibility.spi.impl.java.headless;

    // Provided services
    provides dev.webfx.platform.boot.spi.ApplicationJob with dev.webfx.platform.visibility.spi.impl.java.headless.JavaHeadlessVisibilityJob;
    provides dev.webfx.platform.visibility.spi.VisibilityProvider with dev.webfx.platform.visibility.spi.impl.java.headless.JavaHeadlessVisibilityProvider;

}