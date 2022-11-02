package dev.webfx.platform.streams.spi.impl.gwt;

import dev.webfx.platform.streams.ReadableStream;
import dev.webfx.platform.streams.ReadableStreamDefaultReader;

/**
 * @author Bruno Salmon
 */
public final class GwtReadableStream implements ReadableStream {

    private final elemental2.dom.ReadableStream jsReadableStream;
    private ReadableStreamDefaultReader reader;

    public GwtReadableStream(elemental2.dom.ReadableStream jsReadableStream) {
        this.jsReadableStream = jsReadableStream;
    }

    @Override
    public ReadableStreamDefaultReader getReader() {
        if (reader == null)
            reader = new GwtReadableStreamDefaultReader(jsReadableStream.getReader().asReadableStreamDefaultReader());
        return reader;
    }
}
