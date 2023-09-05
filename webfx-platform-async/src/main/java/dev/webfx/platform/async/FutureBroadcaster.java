package dev.webfx.platform.async;

import dev.webfx.platform.util.function.Callable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Bruno Salmon
 */
public final class FutureBroadcaster<T> {

    private final Callable<Future<T>> sourceProducer;
    private Future<T> source;
    private final Collection<Promise<T>> clients = new ArrayList<>();

    public FutureBroadcaster(Callable<Future<T>> sourceProducer) {
        this.sourceProducer = sourceProducer;
    }

    public FutureBroadcaster(Future<T> source) {
        sourceProducer = null;
        armSource(source);
    }

    private void armSource(Future<T> source) {
        this.source = source;
        source.onComplete(ar -> onSourceCompleted());
    }

    private void onSourceCompleted() {
        synchronized (this) {
            for (Promise<T> destination : clients)
                destination.handle(source);
            clients.clear();
            if (sourceProducer != null)
                source = null;
        }
    }

    public Future<T> newClient() {
        synchronized (this) {
            Promise<T> newClient = Promise.promise();
            clients.add(newClient);
            if (source == null)
                armSource(sourceProducer.call());
            if (source != null && source.isComplete())
                onSourceCompleted();
            return newClient.future();
        }
    }

}
