// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * Gluon implementation of the Visibility API (for mobiles).
 */
module webfx.platform.visibility.gluon {

    // Direct dependencies modules
    requires com.gluonhq.attach.lifecycle;
    requires webfx.platform.console;
    requires webfx.platform.uischeduler;
    requires webfx.platform.visibility;

    // Exported packages
    exports dev.webfx.platform.visibility.spi.impl.gluon;

    // Provided services
    provides dev.webfx.platform.visibility.spi.VisibilityProvider with dev.webfx.platform.visibility.spi.impl.gluon.GluonVisibilityProvider;

}