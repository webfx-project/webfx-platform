package dev.webfx.platform.fetch.spi.impl.vertx;

import dev.webfx.platform.fetch.Headers;
import io.vertx.core.MultiMap;
import io.vertx.core.http.impl.headers.HeadersMultiMap;

import java.util.Iterator;

/**
 * @author Bruno Salmon
 */
final class VertxHeaders implements Headers {

    private final MultiMap headersMultiMap;

    public VertxHeaders() {
        this(HeadersMultiMap.headers());
    }

    public VertxHeaders(MultiMap headersMultiMap) {
        this.headersMultiMap = headersMultiMap;
    }

    public MultiMap getHeadersMultiMap() {
        return headersMultiMap;
    }

    @Override
    public Headers append(String name, String value) {
        headersMultiMap.add(name, value);
        return this;
    }

    @Override
    public Headers delete(String name) {
        headersMultiMap.remove(name);
        return this;
    }

    @Override
    public String get(String name) {
        return headersMultiMap.get(name);
    }

    @Override
    public boolean has(String name) {
        return headersMultiMap.contains(name);
    }

    @Override
    public Headers set(String name, String value) {
        headersMultiMap.set(name, value);
        return this;
    }

    @Override
    public Iterator<String> keys() {
        return headersMultiMap.names().iterator();
    }

    @Override
    public Iterator<String> values() {
        return headersMultiMap.names().stream().map(this::get).iterator();
    }
}
