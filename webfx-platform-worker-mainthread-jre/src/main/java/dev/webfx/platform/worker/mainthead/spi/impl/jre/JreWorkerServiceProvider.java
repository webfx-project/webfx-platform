package dev.webfx.platform.worker.mainthead.spi.impl.jre;

import dev.webfx.platform.worker.Worker;
import dev.webfx.platform.worker.mainthread.spi.WorkerServiceProvider;

/**
 * @author Bruno Salmon
 */
public class JreWorkerServiceProvider implements WorkerServiceProvider {

    @Override
    public Worker createWorker(String applicationWorkerThreadWorkerClass) {
        return new JreWorker(applicationWorkerThreadWorkerClass);
    }
}
