package dev.webfx.platform.streams.spi.impl.gwtj2cl;

import dev.webfx.platform.streams.ReadableStreamDefaultReader;

/**
 * @author Bruno Salmon
 */
public class GwtJ2clReadableStreamDefaultReader implements ReadableStreamDefaultReader {

    private final elemental2.dom.ReadableStreamDefaultReader jsReader;

    public GwtJ2clReadableStreamDefaultReader(elemental2.dom.ReadableStreamDefaultReader jsReader) {
        this.jsReader = jsReader;
    }
}
