package dev.webfx.platform.streams.spi.impl.jre;

import dev.webfx.platform.streams.ReadableStream;
import dev.webfx.platform.streams.ReadableStreamDefaultReader;

/**
 * @author Bruno Salmon
 */
public final class JreReadableStreams implements ReadableStream {

    private final Object underlyingSource;
    private ReadableStreamDefaultReader reader;

    public JreReadableStreams(Object underlyingSource) {
        this.underlyingSource = underlyingSource;
    }

    @Override
    public ReadableStreamDefaultReader getReader() {
        if (reader == null)
            reader = new JreReadableStreamDefaultReader();
        return reader;
    }
}
