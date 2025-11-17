package dev.webfx.platform.worker.workerthread;

import dev.webfx.platform.worker.DelegatingWorker;
import dev.webfx.platform.worker.Worker;

/**
 * @author Bruno Salmon
 */
public abstract class ApplicationWorkerThreadWorkerBase extends DelegatingWorker implements WorkerThreadWorker {

    private WorkerThreadWorker platformWorker;

    public abstract void onLoaded();

    @Override
    public void setDelegate(Worker delegate) {
        platformWorker = (WorkerThreadWorker) delegate;
        super.setDelegate(delegate);
    }

    public final void setPlatformAdapter(PlatformWorkerThreadWorkerAdapter platformAdapter) {
        setDelegate(platformAdapter);
    }

    @Override
    public final void log(String message) {
        platformWorker.log(message);
    }

    @Override
    public final void log(Object object) {
        platformWorker.log(object);
    }

    @Override
    public Object toNativeArray(byte[] byteArray) {
        return platformWorker.toNativeArray(byteArray);
    }

    @Override
    public Object toNativeArray(double[] doubleArray) {
        return platformWorker.toNativeArray(doubleArray);
    }

    @Override
    public Object toNativeArray(int[] intArray) {
        return platformWorker.toNativeArray(intArray);
    }

    @Override
    public int getAstInt(Object nativeObject, String key) {
        return platformWorker.getAstInt(nativeObject, key);
    }

    @Override
    public double getAstDouble(Object nativeObject, String key) {
        return platformWorker.getAstDouble(nativeObject, key);
    }
}
