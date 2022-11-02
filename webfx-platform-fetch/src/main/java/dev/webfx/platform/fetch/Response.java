package dev.webfx.platform.fetch;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.file.Blob;
import dev.webfx.platform.json.WritableJsonArray;
import dev.webfx.platform.json.WritableJsonElement;
import dev.webfx.platform.json.WritableJsonObject;
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

    Future<Blob> blob();

    Future<WritableJsonElement> json();

    default Future<WritableJsonObject> jsonObject() {
        return json().map(WritableJsonElement::asJsonObject);
    }

    default Future<WritableJsonArray> jsonArray() {
        return json().map(WritableJsonElement::asJsonArray);
    }

    Future<String> text();

    ReadableStream body();
}
