package dev.webfx.platform.fetch.json;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.fetch.Fetch;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.json.Json;
import dev.webfx.platform.util.keyobject.ReadOnlyIndexedArray;
import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;
import dev.webfx.platform.util.keyobject.ReadOnlyAstNode;

/**
 * @author Bruno Salmon
 */
public final class JsonFetch {

    public static Future<ReadOnlyKeyObject> fetchJsonObject(String url) {
        return Fetch.fetch(url).compose(Response::text).map(Json::parseObject);
    }

    public static Future<ReadOnlyIndexedArray> fetchJsonArray(String url) {
        return Fetch.fetch(url).compose(Response::text).map(Json::parseArray);
    }

    public static Future<ReadOnlyAstNode> fetchJsonNode(String url) {
        return Fetch.fetch(url).compose(Response::text).map(Json::parseElement);
    }

}
