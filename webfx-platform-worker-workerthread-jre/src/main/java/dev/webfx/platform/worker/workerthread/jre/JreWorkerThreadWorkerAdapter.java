package dev.webfx.platform.worker.workerthread.jre;

import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.console.Console;
import dev.webfx.platform.scheduler.Scheduler;
import dev.webfx.platform.worker.WorkerBase;
import dev.webfx.platform.worker.workerthread.PlatformWorkerThreadWorkerAdapter;

/**
 * @author Bruno Salmon
 */
public final class JreWorkerThreadWorkerAdapter extends WorkerBase implements PlatformWorkerThreadWorkerAdapter {

    private final WorkerBase mainThreadWebWorker;

    public JreWorkerThreadWorkerAdapter(WorkerBase mainThreadWebWorker) {
        this.mainThreadWebWorker = mainThreadWebWorker;
    }

    @Override
    public void log(String message) {
        Console.log(message);
    }

    @Override
    public void log(Object object) {
        Console.log(object);
    }

    @Override
    public Object toNativeArray(byte[] byteArray) {
        return byteArray;
    }

    @Override
    public Object toNativeArray(double[] doubleArray) {
        return doubleArray;
    }

    @Override
    public Object toNativeArray(int[] intArray) {
        return intArray;
    }

    @Override
    public int getAstInt(Object nativeObject, String key) {
        return ((ReadOnlyAstObject) nativeObject).getInteger(key);
    }

    @Override
    public double getAstDouble(Object nativeObject, String key) {
        return ((ReadOnlyAstObject) nativeObject).getDouble(key);
    }

    @Override
    public void postMessage(Object msg) {
        // When the application worker calls this method, we need to pass this to the onMessageHandler of the proxy
        Scheduler.runInUiThread(() -> mainThreadWebWorker.getOnMessageHandler().accept(msg));
    }

    @Override
    public void terminate() {
    }

}
