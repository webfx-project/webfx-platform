package dev.webfx.platform.windowhistory.spi.impl.gwt;

import com.google.gwt.core.client.JavaScriptObject;
import dev.webfx.platform.windowhistory.spi.impl.gwt.jsinterop.Window;

import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.windowhistory.spi.impl.web.JsWindowHistory;
import dev.webfx.platform.async.Handler;
import java.util.function.Function;

/**
 * @author Bruno Salmon
 */
public final class GwtJsWindowHistory implements JsWindowHistory {

    public GwtJsWindowHistory() {
    }

    @Override
    public int length() {
        return Window.history.length;
    }

    @Override
    public void go(int offset) {
        Window.history.go(offset);
    }

    @Override
    public final native boolean supportsStates() /*-{
        return typeof window.history.pushState === 'function';
    }-*/;

    @Override
    public ReadOnlyAstObject state() {
        return Window.history.state.cast();
    }

    @Override
    public void pushState(Object stateObj, String title, String url) {
        Window.history.pushState((JavaScriptObject) stateObj, title, url);
    }

    @Override
    public void replaceState(Object stateObj, String title, String url) {
        Window.history.replaceState((JavaScriptObject) stateObj, title, url);
    }

    @Override
    public void onPopState(Handler<ReadOnlyAstObject> stateListener) {
        Window.onpopstate = event -> stateListener.handle((ReadOnlyAstObject) event.state);
    }

    @Override
    public void onBeforeUnload(Function<ReadOnlyAstObject, String> listener) {
        Window.onbeforeunload = event -> listener.apply((ReadOnlyAstObject) event);
    }

}
