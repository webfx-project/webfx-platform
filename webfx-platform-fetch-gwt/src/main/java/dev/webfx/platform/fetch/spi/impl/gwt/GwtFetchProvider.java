package dev.webfx.platform.fetch.spi.impl.gwt;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.fetch.spi.FetchProvider;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public class GwtFetchProvider implements FetchProvider {

    @Override
    public Future<Response> fetch(String url) {
        Promise<Response> promise = Promise.promise();
        DomGlobal.window.fetch(url)
                .then(r -> {
                    promise.complete(new GwtResponse(r));
                    return null;
                })
                .catch_(error -> {
                    if (error instanceof Throwable)
                        promise.fail((Throwable) error);
                    else
                        promise.fail(error.toString());
                    return null;
                });
        return promise.future();
    }
}
