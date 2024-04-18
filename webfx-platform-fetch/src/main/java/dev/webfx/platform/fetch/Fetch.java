package dev.webfx.platform.fetch;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.fetch.spi.FetchProvider;
import dev.webfx.platform.service.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public class Fetch {

    private Fetch() {}

    private static FetchProvider getProvider() {
        return SingleServiceProvider.getProvider(FetchProvider.class, () -> ServiceLoader.load(FetchProvider.class));
    }

    public static Future<Response> fetch(String url) {
        return fetch(url, null);
    }

    public static Future<Response> fetch(String url, FetchOptions options) {
        return getProvider().fetch(url, options);
    }

    public static Future<String> fetchText(String url) {
        return fetch(url).compose(Response::text);
    }

    public static Future<String> fetchText(String url, FetchOptions options) {
        return fetch(url, options).compose(Response::text);
    }

    public static Headers createHeaders() {
        return getProvider().createHeaders();
    }

}
