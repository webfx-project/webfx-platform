package dev.webfx.platform.fetch.json;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.fetch.Fetch;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.ast.json.Json;
import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.ReadOnlyAstNode;

/**
 * @author Bruno Salmon
 */
public final class JsonFetch {

    public static Future<ReadOnlyAstObject> fetchJsonObject(String url) {
        return Fetch.fetch(url).compose(Response::text).map(Json::parseObject);
    }

    public static Future<ReadOnlyAstArray> fetchJsonArray(String url) {
        return Fetch.fetch(url).compose(Response::text).map(Json::parseArray);
    }

    public static Future<ReadOnlyAstNode> fetchJsonNode(String url) {
        return Fetch.fetch(url).compose(Response::text).map(Json::parseElement);
    }

}
