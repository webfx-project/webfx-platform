package dev.webfx.platform.fetch;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.streams.ReadableStream;

/**
 * @author Bruno Salmon
 */
public interface Response {

    int status();

    String statusText();

    default boolean ok() {
        int status = status();
        return status >= 200 && status < 300;
    }

    default boolean redirected() {
        int status = status();
        return status >= 300 && status < 400;
    }

    String url();

    Headers headers();

    Future<String> text();

    Future<Blob> blob();

    ReadableStream body();
}
