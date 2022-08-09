package dev.webfx.stack.platform.webworker.spi.impl.gwt;

import dev.webfx.stack.platform.webworker.WebWorker;

import java.util.function.Consumer;

/**
 * @author Bruno Salmon
 */
public class GwtWebWorker implements WebWorker {

    private final elemental2.dom.Worker jsWorker;

    public GwtWebWorker(String scriptUrl) {
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
