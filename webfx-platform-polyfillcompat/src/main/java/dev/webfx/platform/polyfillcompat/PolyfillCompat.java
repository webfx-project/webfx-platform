package dev.webfx.platform.polyfillcompat;

import elemental2.dom.FormData;
import elemental2.dom.History;
import elemental2.dom.Response;
import elemental2.dom.Window;

/**
 * @author Bruno Salmon
 */
public final class PolyfillCompat {

    public static Window getOpener(Window window) {
        return window.opener;
    }

    public static History getHistory(Window window) {
        return window.history;
    }

    public static int getLength(History history) {
        return history.length;
    }

    public static boolean isOk(Response response) {
        return response.ok;
    }

    public static String getStatusText(Response response) {
        return response.statusText;
    }

    public static FormData newFormData() {
        return new FormData();
    }
}
