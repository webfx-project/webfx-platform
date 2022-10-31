package dev.webfx.platform.fetch.spi.impl.java;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.file.Blob;
import dev.webfx.platform.file.spi.impl.java.JavaBlob;
import dev.webfx.platform.json.Json;
import dev.webfx.platform.json.JsonObject;
import dev.webfx.platform.streams.ReadableStream;

import java.net.URI;
import java.net.http.HttpResponse;

/**
 * @author Bruno Salmon
 */
public class JavaResponse implements Response {

    private final HttpResponse<?> javaResponse;

    public JavaResponse(HttpResponse<?> javaResponse) {
        this.javaResponse = javaResponse;
    }

    @Override
    public Future<Blob> blob() {
        return Future.succeededFuture(new JavaBlob(javaResponse) {

            @Override
            public long length() {
                return javaResponse.headers().firstValueAsLong("Content-Length").orElse(0);
            }

            @Override
            public String getMimeType() {
                return javaResponse.headers().firstValue("Content-Type").orElse(null);
            }

            @Override
            protected URI toURI() {
                return javaResponse.uri();
            }
        });
    }

    @Override
    public ReadableStream body() {
        return null;
    }

    @Override
    public boolean ok() {
        return true;
    }

    @Override
    public Future<JsonObject> json() {
        return Future.succeededFuture(Json.parseObjectSilently(javaResponse.body().toString()));
    }
}
