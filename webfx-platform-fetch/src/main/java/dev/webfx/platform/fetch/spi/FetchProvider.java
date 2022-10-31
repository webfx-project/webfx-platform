package dev.webfx.platform.fetch.spi;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.fetch.Response;

/**
 * @author Bruno Salmon
 */
public interface FetchProvider {

    Future<Response> fetch(String url);

}
