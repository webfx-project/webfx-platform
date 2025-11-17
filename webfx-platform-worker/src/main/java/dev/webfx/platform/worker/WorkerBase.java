package dev.webfx.platform.worker;

import java.util.function.BiConsumer;

/**
 * @author Bruno Salmon
 */
public abstract class WorkerBase implements Worker {

    private BiConsumer<Object, Object[]> onMessageHandler;

    public BiConsumer<Object, Object[]> getOnMessageHandler() {
        return onMessageHandler;
    }

    @Override
    public void setOnMessageHandler(BiConsumer<Object, Object[]> onMessageHandler) {
        this.onMessageHandler = onMessageHandler;
    }
}
