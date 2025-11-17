package dev.webfx.platform.worker;

import java.util.function.BiConsumer;

/**
 * @author Bruno Salmon
 */
public interface Worker {

    void postMessage(Object msg, Object... transferables);

    void setOnMessageHandler(BiConsumer<Object, Object[]> onMessageHandler);

    void terminate();

}
