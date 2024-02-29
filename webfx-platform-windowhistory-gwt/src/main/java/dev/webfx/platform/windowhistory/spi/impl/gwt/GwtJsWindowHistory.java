package dev.webfx.platform.windowhistory.spi.impl.gwt;

import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.async.Handler;
import dev.webfx.platform.windowhistory.spi.impl.web.JsWindowHistory;
import elemental2.dom.DomGlobal;
import jsinterop.base.Js;

import java.util.function.Function;

/**
 * @author Bruno Salmon
 */
public final class GwtJsWindowHistory implements JsWindowHistory {

    public GwtJsWindowHistory() {
    }

    @Override
    public int length() {
        return DomGlobal.window.history.length;
    }

    @Override
    public void go(int offset) {
        DomGlobal.window.history.go(offset);
    }

    @Override
    public boolean supportsStates() {
        return Js.typeof(Js.asPropertyMap(DomGlobal.window.history).get("pushState")).equals("function");
    }

    @Override
    public ReadOnlyAstObject state() {
        return Js.cast(DomGlobal.window.history.state);
    }

    @Override
    public void pushState(Object stateObj, String title, String url) {
        DomGlobal.window.history.pushState(stateObj, title, url);
    }

    @Override
    public void replaceState(Object stateObj, String title, String url) {
        DomGlobal.window.history.replaceState(stateObj, title, url);
    }

    @Override
    public void onPopState(Handler<ReadOnlyAstObject> stateListener) {
        DomGlobal.window.onpopstate = event -> {
            stateListener.handle(Js.cast(Js.asPropertyMap(event).get("state")));
            return null;
        };
    }

    @Override
    public void onBeforeUnload(Function<ReadOnlyAstObject, String> listener) {
        DomGlobal.window.onbeforeunload = event -> listener.apply(Js.cast(event));
    }

}
