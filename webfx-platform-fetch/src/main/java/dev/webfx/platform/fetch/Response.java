package dev.webfx.platform.fetch;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.json.JsonArray;
import dev.webfx.platform.json.JsonObject;
import dev.webfx.platform.json.JsonElement;
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

    Future<JsonElement> json();

    default Future<JsonObject> jsonObject() {
        return json().map(JsonElement::asJsonObject);
    }

    default Future<JsonArray> jsonArray() {
        return json().map(JsonElement::asJsonArray);
    }

    Future<String> text();

    ReadableStream body();
}
