package dev.webfx.platform.polyfillcompat;

import elemental2.dom.History;
import elemental2.dom.Response;
import elemental2.dom.Window;

/**
 * @author Bruno Salmon
 */
public final class PolyfillCompat {

    public static Window getWindowOpener(Window window) {
        return window.getOpener();
    }

    public static History getWindowHistory(Window window) {
        return window.getHistory();
    }

    public static int getHistoryLength(History history) {
        return history.getLength();
    }

    public static boolean getResponseOk(Response response) {
        return response.isOk();
    }

    public static String getResponseStatusText(Response response) {
        return response.getStatusText();
    }

}
