package dev.webfx.platform.webworker.spi;

import dev.webfx.platform.webworker.WebWorker;
import dev.webfx.platform.webworker.spi.base.JavaCodedWebWorkerBase;

/**
 * @author Bruno Salmon
 */
public interface WorkerServiceProvider {

     WebWorker createWorker(String scriptUrl);

     WebWorker createWorker(Class<? extends JavaCodedWebWorkerBase> javaCodedWorkerClass);
}
