package dev.webfx.platform.fetch.spi.impl.vertx;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import dev.webfx.platform.fetch.Headers;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.streams.ReadableStream;
import io.vertx.core.http.HttpClientResponse;

/**
 * @author Bruno Salmon
 */
final class VertxResponse implements Response {

    private final HttpClientResponse httpClientResponse;

    public VertxResponse(HttpClientResponse httpClientResponse) {
        this.httpClientResponse = httpClientResponse;
    }

    @Override
    public int status() {
        return httpClientResponse.statusCode();
    }

    @Override
    public String statusText() {
        return httpClientResponse.statusMessage();
    }

    @Override
    public String url() {
        return httpClientResponse.request().absoluteURI();
    }

    @Override
    public Headers headers() {
        return new VertxHeaders(httpClientResponse.headers());
    }

    @Override
    public Future<Blob> blob() {
        return Future.failedFuture("Not yet implemented");
    }

    @Override
    public Future<String> text() {
        Promise<String> promise = Promise.promise();
        httpClientResponse.body()
                .onFailure(promise::fail)
                .onSuccess(buffer -> promise.complete(buffer.toString()));
        return promise.future();
    }

    @Override
    public ReadableStream body() {
        return null;
    }

}
