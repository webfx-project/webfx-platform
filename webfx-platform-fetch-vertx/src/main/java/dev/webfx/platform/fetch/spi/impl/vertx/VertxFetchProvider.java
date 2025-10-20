package dev.webfx.platform.fetch.spi.impl.vertx;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import dev.webfx.platform.blob.NamedBlob;
import dev.webfx.platform.fetch.*;
import dev.webfx.platform.fetch.spi.FetchProvider;
import dev.webfx.platform.file.spi.impl.jre.JreFile;
import dev.webfx.platform.util.Strings;
import dev.webfx.platform.util.vertx.VertxInstance;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.AsyncFile;
import io.vertx.core.file.OpenOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.RequestOptions;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.multipart.MultipartForm;

import java.io.File;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public class VertxFetchProvider implements FetchProvider {

    private final WebClient webClient = WebClient.create(VertxInstance.getVertx());

    @Override
    public Future<Response> fetch(String url, FetchOptions options) {
        Promise<Response> promise = Promise.promise();
        HttpMethod method = HttpMethod.valueOf(options == null || options.getMethod() == null ? "GET" : options.getMethod().toUpperCase());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.setAbsoluteURI(url);
        String stringBody = null;
        io.vertx.core.Future<AsyncFile> futureStream = null;
        long streamLength = -1;
        MultipartForm multipartForm = null;
        if (options != null) {
            requestOptions.setMethod(method);
            Headers headers = options.getHeaders();
            if (headers instanceof VertxHeaders)
                requestOptions.setHeaders(((VertxHeaders) headers).getHeadersMultiMap());
            Object body = options.getBody();
            if (body instanceof String) { // Simple String body
                stringBody = (String) body;
            } else if (body instanceof JreFile) { // Single file body
                File file = ((JreFile) body).getPlatformBlob();
                futureStream = VertxInstance.getVertx().fileSystem().open(file.getAbsolutePath(), new OpenOptions());
                streamLength = file.length();
            } else if (body instanceof FormData) { // Form body
                requestOptions.putHeader("Content-Type", "multipart/form-data");
                //io.vertx.core.MultiMap formData = io.vertx.core.MultiMap.caseInsensitiveMultiMap();
                multipartForm = MultipartForm.create();

                for (Map.Entry<String, Object> entry : ((FormData) body).entries()) {
                    Object value = entry.getValue();
                    String filename = null;

                    if (value instanceof NamedBlob) {
                        NamedBlob namedBlob =  (NamedBlob) entry.getValue();
                        value = namedBlob.getBlob();
                        filename = namedBlob.getName();
                    }

                    if (value instanceof JreFile) {
                        JreFile javaFile = (JreFile) value;
                        File file = (File) javaFile.getPlatformBlob();
                        if (filename == null)
                            filename = file.getName();
                        multipartForm.binaryFileUpload(entry.getKey(), filename, file.getAbsolutePath(), javaFile.getMimeType());
                    } else {
                        multipartForm.attribute(entry.getKey(), Strings.toString(value));
                    }
                }
            }
        }

        HttpRequest<Buffer> request = webClient.request(method, requestOptions);
        io.vertx.core.Future<HttpResponse<Buffer>> vertxFuture;

        if (stringBody != null) { // Sending a simple String body
            vertxFuture = request.sendBuffer(Buffer.buffer(stringBody));
        } else if (futureStream != null) { // Sending a single file
            if (streamLength >= 0)
                request.putHeader("content-length", "" + streamLength);
            futureStream
                    .onFailure(promise::fail)
                    .onSuccess(stream -> {
                        request.sendStream(stream)
                                .onFailure(promise::fail)
                                .onSuccess(res -> promise.complete(new VertxResponse(url, res)));
                    });
            vertxFuture = null;
        } else if (multipartForm != null) { // Sending a multipart form
            vertxFuture = request.sendMultipartForm(multipartForm);
        } else
            vertxFuture = request.send();

        if (vertxFuture != null) {
            vertxFuture
                    .onFailure(promise::fail)
                    .onSuccess(res -> promise.complete(new VertxResponse(url, res)));
        }

        return promise.future();
    }

    @Override
    public Headers createHeaders() {
        return new VertxHeaders();
    }
}
