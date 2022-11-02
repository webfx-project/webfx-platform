package dev.webfx.platform.streams.spi.impl.gwt;

import dev.webfx.platform.streams.ReadableStreamDefaultReader;

/**
 * @author Bruno Salmon
 */
public class GwtReadableStreamDefaultReader implements ReadableStreamDefaultReader {

    private final elemental2.dom.ReadableStreamDefaultReader jsReader;

    public GwtReadableStreamDefaultReader(elemental2.dom.ReadableStreamDefaultReader jsReader) {
        this.jsReader = jsReader;
    }
}
