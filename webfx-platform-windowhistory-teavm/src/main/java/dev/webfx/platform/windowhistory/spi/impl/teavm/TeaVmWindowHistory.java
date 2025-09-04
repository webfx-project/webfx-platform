package dev.webfx.platform.windowhistory.spi.impl.teavm;

import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.util.teavm.TeaVmUtil;
import dev.webfx.platform.windowhistory.spi.impl.web.JsWindowHistory;
import org.teavm.jso.JSObject;
import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.events.Event;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Bruno Salmon
 */
public final class TeaVmWindowHistory implements JsWindowHistory {

    public TeaVmWindowHistory() {}

    private static org.teavm.jso.browser.History getCurrentHistory() {
        return Window.current().getHistory();
    }

    @Override
    public int length() {
        return getCurrentHistory().getLength();
    }

    @Override
    public void go(int offset) {
        getCurrentHistory().go(offset);
    }

    @Override
    public boolean supportsStates() {
        return TeaVmUtil.isFunction(TeaVmUtil.getJSObject(getCurrentHistory(), "pushState"));
    }

    @Override
    public ReadOnlyAstObject state() {
        return (ReadOnlyAstObject) getCurrentHistory().getState();
    }

    @Override
    public void pushState(Object stateObj, String title, String url) {
        getCurrentHistory().pushState((JSObject) stateObj, title, url);
    }

    @Override
    public void replaceState(Object stateObj, String title, String url) {
        getCurrentHistory().replaceState((JSObject) stateObj, title, url);
    }

    @Override
    public void onPopState(Consumer<ReadOnlyAstObject> stateListener) {
        Window.current().addEventListener("popstate", (Event evt) -> {
            stateListener.accept((ReadOnlyAstObject) TeaVmUtil.getJSObject(evt, "state"));
        });
    }

    @Override
    public void onBeforeUnload(Function<ReadOnlyAstObject, String> listener) {
        Window.current().addEventListener("onbeforeunload", (Event evt) -> {
            listener.apply((ReadOnlyAstObject) evt);
        });
    }

}