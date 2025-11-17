package dev.webfx.platform.worker.mainthread;

import dev.webfx.platform.service.SingleServiceProvider;
import dev.webfx.platform.worker.Worker;
import dev.webfx.platform.worker.mainthread.spi.WorkerServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public class WorkerService {

    private WorkerService() {}

    private static WorkerServiceProvider getProvider() {
        return SingleServiceProvider.getProvider(WorkerServiceProvider.class, () -> ServiceLoader.load(WorkerServiceProvider.class));
    }

    public static Worker createWorker(String applicationWorkerThreadWorkerClass) {
        return getProvider().createWorker(applicationWorkerThreadWorkerClass);
    }

}
