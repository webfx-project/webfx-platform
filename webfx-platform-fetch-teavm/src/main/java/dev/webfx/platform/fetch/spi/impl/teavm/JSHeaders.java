package dev.webfx.platform.fetch.spi.impl.teavm;

import dev.webfx.platform.util.teavm.JSIterator;
import org.teavm.jso.JSMethod;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
interface JSHeaders extends JSObject {

    void append(String name, String value);

    void set(String name, String value);

    String get(String name);

    boolean has(String name);

    void delete(String name);

    @JSMethod
    JSIterator<String> keys();

    @JSMethod
    JSIterator<String> values();
}