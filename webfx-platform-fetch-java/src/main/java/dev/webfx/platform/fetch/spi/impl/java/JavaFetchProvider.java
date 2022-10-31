package dev.webfx.platform.fetch.spi.impl.java;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.fetch.spi.FetchProvider;
import dev.webfx.platform.scheduler.Scheduler;
import dev.webfx.platform.scheduler.spi.impl.java.JavaSchedulerProvider;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author Bruno Salmon
 */
public class JavaFetchProvider implements FetchProvider {

    private final HttpClient httpClient = HttpClient.newBuilder()
            .executor(((JavaSchedulerProvider) Scheduler.getProvider()).getExecutor())
            .build();

    @Override
    public Future<Response> fetch(String url) {
        Promise<Response> promise = Promise.promise();
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder(new URI(url)).build();
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
}
