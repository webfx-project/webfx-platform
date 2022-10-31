package dev.webfx.platform.fetch.spi.impl.gwt;

import com.google.gwt.core.client.JavaScriptObject;
import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.file.Blob;
import dev.webfx.platform.file.spi.impl.gwt.GwtBlob;
import dev.webfx.platform.json.JsonObject;
import dev.webfx.platform.streams.GwtReadableStream;
import dev.webfx.platform.streams.ReadableStream;

/**
 * @author Bruno Salmon
 */
public class GwtResponse implements Response {

    private final elemental2.dom.Response jsResponse;

    public GwtResponse(elemental2.dom.Response jsResponse) {
        this.jsResponse = jsResponse;
    }

    @Override
    public Future<Blob> blob() {
        Promise<Blob> promise = Promise.promise();
        jsResponse.blob()
                .then(r -> {
                    promise.complete(new GwtBlob(r));
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

    @Override
    public ReadableStream body() {
        return new GwtReadableStream(jsResponse.body);
    }

    @Override
    public boolean ok() {
        return jsResponse.ok;
    }

    @Override
    public Future<JsonObject> json() {
        Promise<JsonObject> promise = Promise.promise();
        jsResponse.json()
                .then(obj -> {
                    promise.complete(((JavaScriptObject) obj).cast());
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
