package dev.webfx.platform.fetch.json;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.fetch.Fetch;
import dev.webfx.platform.fetch.FetchOptions;
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
        return fetchJsonObject(url, null);
    }

    public static Future<ReadOnlyAstObject> fetchJsonObject(String url, FetchOptions fetchOptions) {
        return Fetch.fetchText(url, fetchOptions).compose(text -> {
            try {
                return Future.succeededFuture(Json.parseObject(text));
            } catch (Exception e) {
                return Future.failedFuture(e);
            }
        });
    }

    public static Future<ReadOnlyAstArray> fetchJsonArray(String url) {
        return fetchJsonArray(url, null);
    }

    public static Future<ReadOnlyAstArray> fetchJsonArray(String url, FetchOptions fetchOptions) {
        return Fetch.fetchText(url, fetchOptions).compose(text -> {
            try {
                return Future.succeededFuture(Json.parseArray(text));
            } catch (Exception e) {
                return Future.failedFuture(e);
            }
        });
    }

    public static Future<ReadOnlyAstNode> fetchJsonNode(String url) {
        return fetchJsonNode(url, null);
    }

    public static Future<ReadOnlyAstNode> fetchJsonNode(String url, FetchOptions fetchOptions) {
        return Fetch.fetchText(url, fetchOptions).compose(text -> {
            try {
                return Future.succeededFuture(Json.parseNode(text));
            } catch (Exception e) {
                return Future.failedFuture(e);
            }
        });
    }

}
