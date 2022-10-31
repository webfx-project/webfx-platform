package dev.webfx.platform.streams;

/**
 * @author Bruno Salmon
 */
public class GwtReadableStream implements ReadableStream {

    private final elemental2.dom.ReadableStream jsReadableStream;

    public GwtReadableStream(elemental2.dom.ReadableStream jsReadableStream) {
        this.jsReadableStream = jsReadableStream;
    }
}
