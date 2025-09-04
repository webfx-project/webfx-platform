package dev.webfx.platform.streams.spi.impl.teavm;

import dev.webfx.platform.streams.ReadableStream;
import dev.webfx.platform.streams.ReadableStreamDefaultReader;

/**
 * @author Bruno Salmon
 */
public final class TeaVmReadableStream implements ReadableStream {

    private final org.teavm.jso.streams.ReadableStream jsReadableStream;
    private ReadableStreamDefaultReader reader;

    public TeaVmReadableStream(org.teavm.jso.streams.ReadableStream jsReadableStream) {
        this.jsReadableStream = jsReadableStream;
    }

    @Override
    public ReadableStreamDefaultReader getReader() {
        if (reader == null)
            reader = new TeaVmReadableStreamDefaultReader(jsReadableStream.getReader());
        return reader;
    }
}