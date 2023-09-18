package dev.webfx.platform.fetch.spi.impl.gwt;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.fetch.FetchOptions;
import dev.webfx.platform.fetch.Headers;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.fetch.spi.FetchProvider;
import dev.webfx.platform.ast.AST;
import dev.webfx.platform.ast.AstObject;
import elemental2.dom.DomGlobal;
import elemental2.dom.RequestInit;
import jsinterop.base.Js;

/**
 * @author Bruno Salmon
 */
public class GwtFetchProvider implements FetchProvider {

    @Override
    public Future<Response> fetch(String url, FetchOptions options) {
        RequestInit requestInit = null;
        if (options != null) {
            AstObject js = AST.createObject();
            js.set("method", options.getMethod());
            js.set("mode", options.getMode());
            Headers headers = options.getHeaders();
            if (headers instanceof GwtHeaders)
                js.set("headers", ((GwtHeaders) headers).getJsHeaders());
            requestInit = Js.uncheckedCast(js);
        }
        return GwtUtil.jsPromiseToWebFXFuture(DomGlobal.window.fetch(url, requestInit), GwtResponse::new);
    }

    @Override
    public Headers createHeaders() {
        return new GwtHeaders();
    }
}
