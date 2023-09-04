package dev.webfx.platform.fetch;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.file.Blob;
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

    /**
     * @deprecated
     *
     * Use {@code dev.webfx.platform.fetch.json.JsonFetch.fetchJsonNode()} instead.
     *
     */
    @Deprecated(forRemoval = true)
    Future<JsonElement> json();

    /**
     * @deprecated
     *
     * Use {@code dev.webfx.platform.fetch.json.JsonFetch.fetchJsonObject()} instead.
     *
     */
    @Deprecated(forRemoval = true)
    default Future<JsonObject> jsonObject() {
        return json().map(JsonElement::asJsonObject);
    }

    /**
     * @deprecated
     *
     * Use {@code dev.webfx.platform.fetch.json.JsonFetch.fetchJsonArray()} instead.
     *
     */
    @Deprecated(forRemoval = true)
    default Future<JsonArray> jsonArray() {
        return json().map(JsonElement::asJsonArray);
    }

    Future<String> text();

    ReadableStream body();
}
