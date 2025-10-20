package dev.webfx.platform.polyfillcompat;

import elemental2.dom.Event;

/**
 * @author Bruno Salmon
 */
public final class PolyfillCompat {

    public static native void promptInstallPWA(Event e) /*-{
        e.prompt();
    }-*/;

    public static native boolean isNavigatorStandalone() /*-{
        return navigator.standalone === true;
    }-*/;

}
