package dev.webfx.platform.streams.spi.impl.java;

import dev.webfx.platform.streams.ReadableStream;
import dev.webfx.platform.streams.ReadableStreamDefaultReader;

/**
 * @author Bruno Salmon
 */
public final class JavaReadableStreams implements ReadableStream {

    private final Object underlyingSource;
    private ReadableStreamDefaultReader reader;

    public JavaReadableStreams(Object underlyingSource) {
        this.underlyingSource = underlyingSource;
    }

    @Override
    public ReadableStreamDefaultReader getReader() {
        if (reader == null)
            reader = new JavaReadableStreamDefaultReader();
        return reader;
    }
}
