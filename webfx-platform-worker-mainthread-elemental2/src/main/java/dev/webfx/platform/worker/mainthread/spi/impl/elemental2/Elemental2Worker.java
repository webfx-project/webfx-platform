package dev.webfx.platform.worker.mainthread.spi.impl.elemental2;

import dev.webfx.platform.worker.Worker;

import java.util.function.BiConsumer;

/**
 * @author Bruno Salmon
 */
public final class Elemental2Worker implements Worker {

    private final elemental2.dom.Worker e2Worker;

    public Elemental2Worker(String scriptUrl) {
        e2Worker = new elemental2.dom.Worker(scriptUrl);
    }

    @Override
    public void postMessage(Object msg, Object... transferables) {
        e2Worker.postMessage(msg);
    }

    @Override
    public void setOnMessageHandler(BiConsumer<Object, Object[]> onMessageHandler) {
        e2Worker.onmessage = messageEvent -> onMessageHandler.accept(messageEvent.data, null);
    }

    @Override
    public void terminate() {
        e2Worker.terminate();
    }
}
