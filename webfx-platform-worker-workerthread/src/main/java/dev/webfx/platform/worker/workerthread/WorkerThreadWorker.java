package dev.webfx.platform.worker.workerthread;

import dev.webfx.platform.worker.Worker;

/**
 * @author Bruno Salmon
 */
public interface WorkerThreadWorker extends Worker {

    void log(String message);

    void log(Object object);

    Object toNativeArray(byte[] byteArray);

    Object toNativeArray(double[] doubleArray);

    Object toNativeArray(int[] intArray);

    int getAstInt(Object nativeObject, String key);

    double getAstDouble(Object nativeObject, String key);

}
