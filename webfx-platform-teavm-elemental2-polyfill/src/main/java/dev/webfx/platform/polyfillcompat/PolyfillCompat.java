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
        return window.getOpener();
    }

    public static History getHistory(Window window) {
        return window.getHistory();
    }

    public static int getLength(History history) {
        return history.getLength();
    }

    public static boolean isOk(Response response) {
        return response.isOk();
    }

    public static String getStatusText(Response response) {
        return response.getStatusText();
    }

    public static FormData newFormData() {
        return FormData.create();
    }

}
