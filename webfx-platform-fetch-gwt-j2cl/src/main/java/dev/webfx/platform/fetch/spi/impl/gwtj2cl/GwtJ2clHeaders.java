package dev.webfx.platform.fetch.spi.impl.gwtj2cl;

import dev.webfx.platform.fetch.Headers;
import dev.webfx.platform.util.gwtj2cl.GwtJ2clUtil;

import java.util.Iterator;

/**
 * @author Bruno Salmon
 */
final class GwtJ2clHeaders implements Headers {

    private final elemental2.dom.Headers jsHeaders;

    public GwtJ2clHeaders() {
        this(new elemental2.dom.Headers());
    }

    public GwtJ2clHeaders(elemental2.dom.Headers jsHeaders) {
        this.jsHeaders = jsHeaders;
    }

    public elemental2.dom.Headers getJsHeaders() {
        return jsHeaders;
    }

    @Override
    public Headers append(String name, String value) {
        jsHeaders.append(name, value);
        return this;
    }

    @Override
    public Headers delete(String name) {
        jsHeaders.delete(name);
        return this;
    }

    @Override
    public String get(String name) {
        return jsHeaders.get(name);
    }

    @Override
    public boolean has(String name) {
        return jsHeaders.has(name);
    }

    @Override
    public Headers set(String name, String value) {
        jsHeaders.set(name, value);
        return this;
    }

    @Override
    public Iterator<String> keys() {
        return GwtJ2clUtil.jsIteratorToJavaIterator(jsHeaders.keys());
    }

    @Override
    public Iterator<String> values() {
        return GwtJ2clUtil.jsIteratorToJavaIterator(jsHeaders.values());
    }
}
