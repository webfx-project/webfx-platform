package dev.webfx.platform.worker.mainthread.spi;

import dev.webfx.platform.worker.Worker;

/**
 * @author Bruno Salmon
 */
public interface WorkerServiceProvider {

     Worker createWorker(String applicationWorkerThreadWorkerClass);

}
