package dev.webfx.platform.streams.spi.impl.teavm;

import dev.webfx.platform.streams.ReadableStreamDefaultReader;

/**
 * @author Bruno Salmon
 */
public final class TeaVmReadableStreamDefaultReader implements ReadableStreamDefaultReader {

    private final org.teavm.jso.streams.ReadableStreamDefaultReader jsReader;

    public TeaVmReadableStreamDefaultReader(org.teavm.jso.streams.ReadableStreamDefaultReader jsReader) {
        this.jsReader = jsReader;
    }
}