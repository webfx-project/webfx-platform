package dev.webfx.platform.streams.spi.impl.gwtj2cl;

import dev.webfx.platform.streams.ReadableStream;
import dev.webfx.platform.streams.ReadableStreamDefaultReader;

/**
 * @author Bruno Salmon
 */
public final class GwtJ2clReadableStream implements ReadableStream {

    private final elemental2.dom.ReadableStream jsReadableStream;
    private ReadableStreamDefaultReader reader;

    public GwtJ2clReadableStream(elemental2.dom.ReadableStream jsReadableStream) {
        this.jsReadableStream = jsReadableStream;
    }

    @Override
    public ReadableStreamDefaultReader getReader() {
        if (reader == null)
            reader = new GwtJ2clReadableStreamDefaultReader(jsReadableStream.getReader().asReadableStreamDefaultReader());
        return reader;
    }
}
