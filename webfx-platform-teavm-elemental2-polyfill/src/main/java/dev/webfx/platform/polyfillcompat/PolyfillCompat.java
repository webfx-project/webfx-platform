package dev.webfx.platform.polyfillcompat;

import elemental2.dom.Event;
import org.teavm.jso.JSBody;

/**
 * @author Bruno Salmon
 */
public final class PolyfillCompat {

    @JSBody(params = {"e"}, script = "e.prompt();")
    public static native void promptInstallPWA(Event e);

    @JSBody(script = "return navigator.standalone === true;")
    public static native boolean isNavigatorStandalone();

}
