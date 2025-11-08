package dev.webfx.platform.worker.mainthread.spi.impl.elemental2;

import dev.webfx.platform.worker.Worker;
import dev.webfx.platform.worker.mainthread.spi.WorkerServiceProvider;

/**
 * @author Bruno Salmon
 */
public final class Elemental2WorkerServiceProvider implements WorkerServiceProvider {

    @Override
    public Worker createWorker(String applicationWorkerThreadWorkerClass) {
        return new Elemental2Worker(applicationWorkerThreadWorkerClass + ".js");
    }
}
