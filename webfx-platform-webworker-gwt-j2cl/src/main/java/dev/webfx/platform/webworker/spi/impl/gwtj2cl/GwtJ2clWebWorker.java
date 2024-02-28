package dev.webfx.platform.webworker.spi.impl.gwtj2cl;

import dev.webfx.platform.webworker.WebWorker;

import java.util.function.Consumer;

/**
 * @author Bruno Salmon
 */
public class GwtJ2clWebWorker implements WebWorker {

    private final elemental2.dom.Worker jsWorker;

    public GwtJ2clWebWorker(String scriptUrl) {
        jsWorker = new elemental2.dom.Worker(scriptUrl);
    }

    @Override
    public void postMessage(Object msg) {
        jsWorker.postMessage(msg);
    }

    @Override
    public void setOnMessageHandler(Consumer<Object> onMessageHandler) {
        jsWorker.onmessage = messageEvent -> onMessageHandler.accept(messageEvent.data);
    }

    @Override
    public void terminate() {
        jsWorker.terminate();
    }
}
