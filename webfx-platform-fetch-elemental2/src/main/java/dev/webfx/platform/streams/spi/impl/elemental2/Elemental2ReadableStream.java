package dev.webfx.platform.streams.spi.impl.elemental2;

import dev.webfx.platform.streams.ReadableStream;
import dev.webfx.platform.streams.ReadableStreamDefaultReader;

/**
 * @author Bruno Salmon
 */
public final class Elemental2ReadableStream implements ReadableStream {

    private final elemental2.dom.ReadableStream jsReadableStream;
    private ReadableStreamDefaultReader reader;

    public Elemental2ReadableStream(elemental2.dom.ReadableStream jsReadableStream) {
        this.jsReadableStream = jsReadableStream;
    }

    @Override
    public ReadableStreamDefaultReader getReader() {
        if (reader == null)
            reader = new Elemental2ReadableStreamDefaultReader(jsReadableStream.getReader().asReadableStreamDefaultReader());
        return reader;
    }
}
