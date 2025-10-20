package dev.webfx.platform.streams.spi.impl.elemental2;

import dev.webfx.platform.streams.ReadableStreamDefaultReader;

/**
 * @author Bruno Salmon
 */
public class Elemental2ReadableStreamDefaultReader implements ReadableStreamDefaultReader {

    private final elemental2.dom.ReadableStreamDefaultReader jsReader;

    public Elemental2ReadableStreamDefaultReader(elemental2.dom.ReadableStreamDefaultReader jsReader) {
        this.jsReader = jsReader;
    }
}
