package dev.webfx.platform.fetch.spi.impl.teavm;

import dev.webfx.platform.fetch.Headers;
import dev.webfx.platform.util.teavm.TeaVmUtil;
import org.teavm.jso.JSBody;

import java.util.Iterator;

/**
 * @author Bruno Salmon
 */
final class TeaVmHeaders implements Headers {

    private final JSHeaders jsHeaders;

    public TeaVmHeaders() {
        this(createHeaders());
    }

    public TeaVmHeaders(JSHeaders jsHeaders) {
        this.jsHeaders = jsHeaders;
    }

    public JSHeaders getJsHeaders() {
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
        return TeaVmUtil.jsIteratorToJavaIterator(jsHeaders.keys());
    }

    @Override
    public Iterator<String> values() {
        return TeaVmUtil.jsIteratorToJavaIterator(jsHeaders.values());
    }

    @JSBody(script = "return new Headers();")
    private static native JSHeaders createHeaders();

}