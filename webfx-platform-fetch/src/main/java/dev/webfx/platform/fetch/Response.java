package dev.webfx.platform.fetch;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.file.Blob;
import dev.webfx.platform.json.JsonObject;
import dev.webfx.platform.streams.ReadableStream;

/**
 * @author Bruno Salmon
 */
public interface Response {

    Future<Blob> blob();

    ReadableStream body();

    boolean ok();

    Future<JsonObject> json();

}
