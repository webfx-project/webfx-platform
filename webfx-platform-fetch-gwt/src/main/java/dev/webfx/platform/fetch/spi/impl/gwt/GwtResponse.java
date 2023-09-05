package dev.webfx.platform.fetch.spi.impl.gwt;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.fetch.Headers;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.blob.spi.impl.gwt.GwtBlob;
import dev.webfx.platform.streams.ReadableStream;
import dev.webfx.platform.streams.spi.impl.gwt.GwtReadableStream;

/**
 * @author Bruno Salmon
 */
public class GwtResponse implements Response {

    private final elemental2.dom.Response jsResponse;
    private Headers headers;
    private ReadableStream body;

    public GwtResponse(elemental2.dom.Response jsResponse) {
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
            headers = new GwtHeaders(jsResponse.headers);
        return headers;
    }

    @Override
    public Future<Blob> blob() {
        return GwtUtil.jsPromiseToWebFXFuture(jsResponse.blob(), GwtBlob::new);
    }

    @Override
    public Future<String> text() {
        return GwtUtil.jsPromiseToWebFXFuture(jsResponse.text(), text -> text);
    }

    @Override
    public ReadableStream body() {
        if (body == null)
            body = new GwtReadableStream(jsResponse.body);
        return body;
    }

}
