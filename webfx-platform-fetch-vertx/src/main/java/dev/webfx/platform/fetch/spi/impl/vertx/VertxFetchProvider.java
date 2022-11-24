package dev.webfx.platform.fetch.spi.impl.vertx;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import dev.webfx.platform.fetch.FetchOptions;
import dev.webfx.platform.fetch.Headers;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.fetch.spi.FetchProvider;
import dev.webfx.platform.vertx.common.VertxInstance;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.RequestOptions;

/**
 * @author Bruno Salmon
 */
public class VertxFetchProvider implements FetchProvider {

    private final HttpClient httpClient = VertxInstance.getVertx().createHttpClient();

    @Override
    public Future<Response> fetch(String url, FetchOptions options) {
        Promise<Response> promise = Promise.promise();
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.setAbsoluteURI(url);
        if (options != null) {
            String mode = options.getMode();
            HttpMethod method = HttpMethod.valueOf(mode == null ? "GET" : mode.toUpperCase());
            requestOptions.setMethod(method);
            Headers headers = options.getHeaders();
            if (headers instanceof VertxHeaders)
                requestOptions.setHeaders(((VertxHeaders) headers).getHeadersMultiMap());
        }
        httpClient.request(requestOptions)
                .onFailure(promise::fail)
                .onSuccess(req -> req.send()
                        .onFailure(promise::fail)
                        .onSuccess(res -> promise.complete(new VertxResponse(res)))
                );
        return promise.future();
    }

    @Override
    public Headers createHeaders() {
        return new VertxHeaders();
    }
}
