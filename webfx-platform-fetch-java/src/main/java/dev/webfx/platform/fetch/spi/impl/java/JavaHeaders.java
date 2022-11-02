package dev.webfx.platform.fetch.spi.impl.java;

import dev.webfx.platform.fetch.Headers;

import java.util.*;

/**
 * @author Bruno Salmon
 */
final class JavaHeaders implements Headers {

    private final Map<String, List<String>> headersMap;

    public JavaHeaders() {
        this(new HashMap<>());
    }

    public JavaHeaders(Map<String, List<String>> headersMap) {
        this.headersMap = headersMap;
    }

    public Map<String, List<String>> getHeadersMap() {
        return headersMap;
    }

    private List<String> getValues(String name) {
        return headersMap.computeIfAbsent(name, k -> new ArrayList<>());
    }

    @Override
    public Headers append(String name, String value) {
        getValues(name).add(value);
        return this;
    }

    @Override
    public Headers delete(String name) {
        headersMap.remove(name);
        return this;
    }

    @Override
    public String get(String name) {
        return getValues(name).stream().findFirst().orElse(null);
    }

    @Override
    public boolean has(String name) {
        return !getValues(name).isEmpty();
    }

    @Override
    public Headers set(String name, String value) {
        List<String> values = getValues(name);
        values.clear();
        values.add(value);
        return this;
    }

    @Override
    public Iterator<String> keys() {
        return getHeadersMap().keySet().iterator();
    }

    @Override
    public Iterator<String> values() {
        return new Iterator<>() {

            private final Iterator<List<String>> globalIt = headersMap.values().iterator();
            private Iterator<String> valueIt;

            @Override
            public boolean hasNext() {
                return valueIt != null && valueIt.hasNext() || globalIt.hasNext();
            }

            @Override
            public String next() {
                if (valueIt == null || !valueIt.hasNext()) {
                    if (globalIt.hasNext())
                        valueIt = globalIt.next().iterator();
                    else
                        return null;
                }
                return valueIt.next();
            }
        };
    }
}
