package dev.webfx.platform.worker.mainthread;

import dev.webfx.platform.worker.DelegatingWorker;
import dev.webfx.platform.worker.Worker;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Bruno Salmon
 */
public final class WorkerPool {

    private final String workerClass;
    private final Queue<Worker> pool = new LinkedList<>();

    public WorkerPool(String workerClass) {
        this.workerClass = workerClass;
    }

    public Worker getWorker() {
        Worker webWorker = pool.poll();
        if (webWorker == null)
            webWorker = new PooledWorker();
        return webWorker;
    }

    public void releaseWorker(Worker webWorker) {
        pool.add(webWorker);
    }

    private class PooledWorker extends DelegatingWorker {

        public PooledWorker() {
            super(WorkerService.createWorker(workerClass));
        }

        @Override
        public void terminate() {
            releaseWorker(this);
        }
    }
}
