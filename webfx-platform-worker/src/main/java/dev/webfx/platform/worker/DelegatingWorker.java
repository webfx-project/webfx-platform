package dev.webfx.platform.worker;

import java.util.function.Consumer;

/**
 * @author Bruno Salmon
 */
public class DelegatingWorker implements Worker {

    private Worker delegate;

    public DelegatingWorker() {
    }

    public DelegatingWorker(Worker delegate) {
        setDelegate(delegate);
    }

    public void setDelegate(Worker delegate) {
        this.delegate = delegate;
    }

    @Override
    public void postMessage(Object msg) {
        delegate.postMessage(msg);
    }

    @Override
    public void setOnMessageHandler(Consumer<Object> onMessageHandler) {
        delegate.setOnMessageHandler(onMessageHandler);
    }

    @Override
    public void terminate() {
        delegate.terminate();
    }
}
