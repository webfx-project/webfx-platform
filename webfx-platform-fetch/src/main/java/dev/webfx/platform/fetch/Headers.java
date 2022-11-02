package dev.webfx.platform.fetch;

import java.util.Iterator;

/**
 * @author Bruno Salmon
 */
public interface Headers {

    Headers append(String name, String value);

    Headers delete(String name);

    String get(String name);

    boolean has(String name);

    Headers set(String name, String value);

    Iterator<String> keys();

    Iterator<String> values();

    static Headers create() {
        return Fetch.createHeaders();
    }
}
