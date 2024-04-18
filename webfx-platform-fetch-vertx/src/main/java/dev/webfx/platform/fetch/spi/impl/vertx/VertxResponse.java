package dev.webfx.platform.fetch.spi.impl.vertx;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.fetch.Headers;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.streams.ReadableStream;
import io.vertx.ext.web.client.HttpResponse;

/**
 * @author Bruno Salmon
 */
final class VertxResponse implements Response {

    private final String url;
    private final HttpResponse httpResponse;

    public VertxResponse(String url, HttpResponse httpResponse) {
        this.url = url;
        this.httpResponse = httpResponse;
    }

    @Override
    public int status() {
        return httpResponse.statusCode();
    }

    @Override
    public String statusText() {
        return httpResponse.statusMessage();
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public Headers headers() {
        return new VertxHeaders(httpResponse.headers());
    }

    @Override
    public Future<Blob> blob() {
        return Future.failedFuture("Not yet implemented");
    }

    @Override
    public Future<String> text() {
        // Note: as we use WebClient (not HttpClient), HttpResponse has already the full content in memory.
        // Vert.x note: Keep in mind that using this HttpResponse impose to fully buffer the response body and should be
        // used for payload that can fit in memory.
        return Future.succeededFuture(httpResponse.bodyAsString());
    }

    @Override
    public ReadableStream body() {
        return null;
    }

}
