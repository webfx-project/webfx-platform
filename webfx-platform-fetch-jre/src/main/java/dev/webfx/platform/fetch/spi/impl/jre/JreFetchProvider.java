package dev.webfx.platform.fetch.spi.impl.jre;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import dev.webfx.platform.blob.NamedBlob;
import dev.webfx.platform.blob.spi.impl.jre.JreBlob;
import dev.webfx.platform.fetch.*;
import dev.webfx.platform.fetch.spi.FetchProvider;
import dev.webfx.platform.scheduler.Scheduler;
import dev.webfx.platform.scheduler.spi.impl.jre.JreSchedulerProvider;
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

import static dev.webfx.platform.util.http.HttpHeaders.*;

/**
 * @author Bruno Salmon
 */
public final class JreFetchProvider implements FetchProvider {

    private final HttpClient httpClient = HttpClient.newBuilder()
            .executor(((JreSchedulerProvider) Scheduler.getProvider()).getExecutor())
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
                if (body instanceof String stringBody)
                    bodyPublisher = HttpRequest.BodyPublishers.ofString(stringBody);
                else if (body instanceof JreBlob jreBlob) {
                    Object platformBlob = jreBlob.getPlatformBlob();
                    if (platformBlob instanceof File file)
                        bodyPublisher = HttpRequest.BodyPublishers.ofFile(file.toPath());
                } else if (body instanceof FormData formData) {
                    MultiPartBodyPublisher multiPartBodyPublisher = buildMultipartBody(formData);
                    if (headers == null)
                        headers = createHeaders();
                    headers.set(CONTENT_TYPE, multipartFormDataWithBoundary(multiPartBodyPublisher.getBoundary()));
                    bodyPublisher = multiPartBodyPublisher.build();
                }
                builder.method(options.getMethod(), bodyPublisher);
                if (headers instanceof JreHeaders)
                    for (Map.Entry<String, List<String>> entry : ((JreHeaders) headers).getHeadersMap().entrySet())
                        for (String value : entry.getValue())
                            builder.header(entry.getKey(), value);
            }
            HttpRequest httpRequest = builder.build();
            httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
                    .handleAsync((stringHttpResponse, throwable) -> {
                        if (throwable != null)
                            promise.fail(throwable);
                        else
                            promise.complete(new JreResponse(stringHttpResponse));
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
        return new JreHeaders();
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

            if (value instanceof JreBlob jreBlob) {
                File file = (File) jreBlob.getPlatformBlob();
                if (filename == null)
                    filename = file.getName();
                FileInputStream fileInputStream = new FileInputStream(file);
                builder.addPart(entry.getKey(), () -> fileInputStream, filename, jreBlob.getMimeType());
            } else {
                builder.addPart(entry.getKey(), Strings.toString(value));
            }
        }

        return builder;
    }

}
