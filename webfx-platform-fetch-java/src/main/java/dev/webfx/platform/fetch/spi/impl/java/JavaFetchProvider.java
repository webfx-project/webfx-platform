package dev.webfx.platform.fetch.spi.impl.java;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import dev.webfx.platform.blob.spi.impl.java.JavaBlob;
import dev.webfx.platform.fetch.*;
import dev.webfx.platform.fetch.spi.FetchProvider;
import dev.webfx.platform.scheduler.Scheduler;
import dev.webfx.platform.scheduler.spi.impl.java.JavaSchedulerProvider;
import dev.webfx.platform.util.Strings;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public final class JavaFetchProvider implements FetchProvider {

    private final HttpClient httpClient = HttpClient.newBuilder()
            .executor(((JavaSchedulerProvider) Scheduler.getProvider()).getExecutor())
            .build();

    @Override
    public Future<Response> fetch(String url, FetchOptions options) {
        Promise<Response> promise = Promise.promise();
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder(new URI(url));
            if (options != null) {
                Headers headers = options.getHeaders();
                HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.noBody();
                Object body = options.getBody();
                if (body instanceof String)
                    bodyPublisher = HttpRequest.BodyPublishers.ofString((String) body);
                else if (body instanceof JavaBlob) {
                    Object plaformBlob = ((JavaBlob) body).getPlatformBlob();
                    if (plaformBlob instanceof File)
                        bodyPublisher = HttpRequest.BodyPublishers.ofFile(((File) plaformBlob).toPath());
                } else if (body instanceof FormData) {
                    MultiPartBodyPublisher multiPartBodyPublisher = buildMultipartBody((FormData) body);
                    if (headers == null)
                        headers = createHeaders();
                    headers.set(Headers.CONTENT_TYPE, Headers.multipartFormDataWithBoundary(multiPartBodyPublisher.getBoundary()));
                    bodyPublisher = multiPartBodyPublisher.build();
                }
                builder.method(options.getMethod(), bodyPublisher);
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

    private MultiPartBodyPublisher buildMultipartBody(FormData formData) throws IOException {
        MultiPartBodyPublisher builder = new MultiPartBodyPublisher();

        // Append each form field
        for (Map.Entry<String, Object> entry : formData.entries()) {
            Object value = entry.getValue();
            String filename = null;

            if (value instanceof NamedBlob) {
                NamedBlob namedBlob =  (NamedBlob) entry.getValue();
                value = namedBlob.getBlob();
                filename = namedBlob.getName();
            }

            if (value instanceof JavaBlob) {
                JavaBlob javaBlob = (JavaBlob) value;
                File file = (File) javaBlob.getPlatformBlob();
                if (filename == null)
                    filename = file.getName();
                FileInputStream fileInputStream = new FileInputStream(file);
                builder.addPart(entry.getKey(), () -> fileInputStream, filename, null);
            } else {
                builder.addPart(entry.getKey(), Strings.asString(value));
            }
        }

        return builder;
    }

}
