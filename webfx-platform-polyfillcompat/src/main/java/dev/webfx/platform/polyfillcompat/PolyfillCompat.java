package dev.webfx.platform.polyfillcompat;

import elemental2.dom.History;
import elemental2.dom.Response;
import elemental2.dom.Window;

/**
 * @author Bruno Salmon
 */
public final class PolyfillCompat {

    public static Window getWindowOpener(Window window) {
        return window.opener;
    }

    public static History getWindowHistory(Window window) {
        return window.history;
    }

    public static int getHistoryLength(History history) {
        return history.length;
    }

    public static boolean getResponseOk(Response response) {
        return response.ok;
    }

    public static String getResponseStatusText(Response response) {
        return response.statusText;
    }


}
