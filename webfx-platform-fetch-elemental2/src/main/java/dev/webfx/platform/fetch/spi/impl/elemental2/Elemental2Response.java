package dev.webfx.platform.fetch.spi.impl.elemental2;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.blob.spi.impl.elemental2.Elemental2Blob;
import dev.webfx.platform.fetch.Headers;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.streams.ReadableStream;
import dev.webfx.platform.streams.spi.impl.elemental2.Elemental2ReadableStream;
import dev.webfx.platform.util.elemental2.async.Elemental2Async;

/**
 * @author Bruno Salmon
 */
public class Elemental2Response implements Response {

    private final elemental2.dom.Response jsResponse;
    private Headers headers;
    private ReadableStream body;

    public Elemental2Response(elemental2.dom.Response jsResponse) {
        this.jsResponse = jsResponse;
    }

    @Override
    public int status() {
        return jsResponse.status;
    }

    @Override
    public String statusText() {
        return jsResponse.statusText;
    }

    @Override
    public boolean ok() {
        return jsResponse.ok;
    }

    @Override
    public boolean redirected() {
        return jsResponse.redirected;
    }

    @Override
    public String url() {
        return jsResponse.url;
    }

    @Override
    public Headers headers() {
        if (headers == null)
            headers = new Elemental2Headers(jsResponse.headers);
        return headers;
    }

    @Override
    public Future<Blob> blob() {
        return Elemental2Async.jsPromiseToWebFXFuture(jsResponse.blob())
            .map(Elemental2Blob::new);
    }

    @Override
    public Future<String> text() {
        return Elemental2Async.jsPromiseToWebFXFuture(jsResponse.text());
    }

    @Override
    public ReadableStream body() {
        if (body == null)
            body = new Elemental2ReadableStream(jsResponse.body);
        return body;
    }

}
