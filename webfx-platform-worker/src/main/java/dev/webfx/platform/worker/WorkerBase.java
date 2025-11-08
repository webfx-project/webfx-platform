package dev.webfx.platform.worker;

import java.util.function.Consumer;

/**
 * @author Bruno Salmon
 */
public abstract class WorkerBase implements Worker {

    private Consumer<Object> onMessageHandler;

    public Consumer<Object> getOnMessageHandler() {
        return onMessageHandler;
    }

    @Override
    public void setOnMessageHandler(Consumer<Object> onMessageHandler) {
        this.onMessageHandler = onMessageHandler;
    }
}
