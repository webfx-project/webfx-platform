package dev.webfx.platform.fetch.spi.impl.gwtj2cl;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.fetch.Headers;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.blob.spi.impl.gwtj2cl.GwtJ2clBlob;
import dev.webfx.platform.streams.ReadableStream;
import dev.webfx.platform.streams.spi.impl.gwtj2cl.GwtJ2clReadableStream;

/**
 * @author Bruno Salmon
 */
public class GwtJ2clResponse implements Response {

    private final elemental2.dom.Response jsResponse;
    private Headers headers;
    private ReadableStream body;

    public GwtJ2clResponse(elemental2.dom.Response jsResponse) {
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
            headers = new GwtJ2clHeaders(jsResponse.headers);
        return headers;
    }

    @Override
    public Future<Blob> blob() {
        return GwtJ2clUtil.jsPromiseToWebFXFuture(jsResponse.blob(), GwtJ2clBlob::new);
    }

    @Override
    public Future<String> text() {
        return GwtJ2clUtil.jsPromiseToWebFXFuture(jsResponse.text(), text -> text);
    }

    @Override
    public ReadableStream body() {
        if (body == null)
            body = new GwtJ2clReadableStream(jsResponse.body);
        return body;
    }

}
