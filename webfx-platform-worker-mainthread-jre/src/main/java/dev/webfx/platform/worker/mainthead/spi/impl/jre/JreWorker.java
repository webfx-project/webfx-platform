package dev.webfx.platform.worker.mainthead.spi.impl.jre;

import dev.webfx.platform.console.Console;
import dev.webfx.platform.worker.WorkerBase;
import dev.webfx.platform.worker.workerthread.ApplicationWorkerThreadWorkerBase;
import dev.webfx.platform.worker.workerthread.jre.JreWorkerThreadWorkerAdapter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Bruno Salmon
 */
public final class JreWorker extends WorkerBase { // this instance represents the proxy the application interacts with

    private final ScheduledExecutorService workerExecutor = Executors.newSingleThreadScheduledExecutor();

    private final ApplicationWorkerThreadWorkerBase applicationWorker; // This instance represents the actual running worker coded in Java (instantiated through the passed class)
    private final JreWorkerThreadWorkerAdapter jrePlatformAdapter = new JreWorkerThreadWorkerAdapter(this);

    public JreWorker(String applicationWorkerThreadWorkerClass) {
        ApplicationWorkerThreadWorkerBase javaApplicationWorker;
        try {
            Class<?> workerClass = Class.forName(applicationWorkerThreadWorkerClass);
            javaApplicationWorker = (ApplicationWorkerThreadWorkerBase) workerClass.getDeclaredConstructor().newInstance();
            javaApplicationWorker.setPlatformAdapter(jrePlatformAdapter);
        } catch (Exception e) {
            Console.log(e);
            javaApplicationWorker = null;
        }
        this.applicationWorker = javaApplicationWorker;
        javaApplicationWorker.onLoaded();
    }

    @Override
    public void postMessage(Object msg) {
        // When the application calls this method, we need to pass this to the onMessageHandler of the application
        workerExecutor.schedule(() -> jrePlatformAdapter.getOnMessageHandler().accept(msg), 0, TimeUnit.SECONDS);
    }

    @Override
    public void terminate() {
        applicationWorker.terminate();
        workerExecutor.shutdown();
    }
}
