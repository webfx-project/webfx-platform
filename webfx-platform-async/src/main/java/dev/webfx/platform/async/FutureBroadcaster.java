package dev.webfx.platform.async;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

/**
 * @author Bruno Salmon
 */
public final class FutureBroadcaster<T> {

    private final Supplier<Future<T>> sourceSupplier;
    private Future<T> source;
    private final Collection<Promise<T>> clients = new ArrayList<>();

    public FutureBroadcaster(Supplier<Future<T>> sourceSupplier) {
        this.sourceSupplier = sourceSupplier;
    }

    public FutureBroadcaster(Future<T> source) {
        sourceSupplier = null;
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
            if (sourceSupplier != null)
                source = null;
        }
    }

    public Future<T> newClient() {
        synchronized (this) {
            Promise<T> newClient = Promise.promise();
            clients.add(newClient);
            if (source == null)
                armSource(sourceSupplier.get());
            if (source != null && source.isComplete())
                onSourceCompleted();
            return newClient.future();
        }
    }

}
