package dev.webfx.platform.fetch;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.fetch.spi.FetchProvider;
import dev.webfx.platform.util.serviceloader.SingleServiceProvider;

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

    public static Headers createHeaders() {
        return getProvider().createHeaders();
    }

}
