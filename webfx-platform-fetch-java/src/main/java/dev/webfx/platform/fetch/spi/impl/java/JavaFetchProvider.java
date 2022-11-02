package dev.webfx.platform.fetch.spi.impl.java;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import dev.webfx.platform.fetch.FetchOptions;
import dev.webfx.platform.fetch.Headers;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.fetch.spi.FetchProvider;
import dev.webfx.platform.scheduler.Scheduler;
import dev.webfx.platform.scheduler.spi.impl.java.JavaSchedulerProvider;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public class JavaFetchProvider implements FetchProvider {

    private final HttpClient httpClient = HttpClient.newBuilder()
            .executor(((JavaSchedulerProvider) Scheduler.getProvider()).getExecutor())
            .build();

    @Override
    public Future<Response> fetch(String url, FetchOptions options) {
        Promise<Response> promise = Promise.promise();
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder(new URI(url));
            if (options != null) {
                builder.method(options.getMethod(), HttpRequest.BodyPublishers.noBody());
                Headers headers = options.getHeaders();
                if (headers instanceof JavaHeaders)
                    for (Map.Entry<String, List<String>> entry : ((JavaHeaders) headers).getHeadersMap().entrySet())
                        for (String value : entry.getValue())
                            builder.header(entry.getKey(), value);
            }
            HttpRequest httpRequest = builder.build();
            httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
                    .handleAsync((stringHttpResponse, throwable) -> {
                        if (throwable != null)
                            promise.fail(throwable);
                        else
                            promise.complete(new JavaResponse(stringHttpResponse));
                        return null;
                    })
            ;
        } catch (Throwable e) {
            promise.fail(e);
        }
        return promise.future();
    }

    @Override
    public Headers createHeaders() {
        return new JavaHeaders();
    }
}
