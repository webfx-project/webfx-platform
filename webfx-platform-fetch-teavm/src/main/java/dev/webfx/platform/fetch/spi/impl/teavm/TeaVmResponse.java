package dev.webfx.platform.fetch.spi.impl.teavm;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.blob.spi.impl.teavm.TeaVmBlob;
import dev.webfx.platform.fetch.Headers;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.streams.ReadableStream;
import dev.webfx.platform.streams.spi.impl.teavm.TeaVmReadableStream;
import dev.webfx.platform.util.teavm.TeaVmUtil;
import org.teavm.jso.core.JSString;

/**
 * @author Bruno Salmon
 */
final class TeaVmResponse implements Response {

    private final JSResponse jsResponse;
    private Headers headers;
    private ReadableStream body;

    public TeaVmResponse(JSResponse jsResponse) {
        this.jsResponse = jsResponse;
    }

    @Override
    public int status() {
        return jsResponse.getStatus();
    }

    @Override
    public String statusText() {
        return jsResponse.getStatusText();
    }

    @Override
    public boolean ok() {
        return jsResponse.isOk();
    }

    @Override
    public boolean redirected() {
        return jsResponse.isRedirected();
    }

    @Override
    public String url() {
        return jsResponse.getURL();
    }

    @Override
    public Headers headers() {
        if (headers == null)
            headers = new TeaVmHeaders(jsResponse.getHeaders());
        return headers;
    }

    @Override
    public Future<Blob> blob() {
        return TeaVmUtil.jsPromiseToWebFXFuture(jsResponse.blob(), TeaVmBlob::new);
    }

    @Override
    public Future<String> text() {
        return TeaVmUtil.jsPromiseToWebFXFuture(jsResponse.text(), JSString::stringValue);
    }

    @Override
    public ReadableStream body() {
        if (body == null)
            body = new TeaVmReadableStream(jsResponse.getBody());
        return body;
    }

}