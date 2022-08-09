package dev.webfx.stack.platform.webworker.spi;

import dev.webfx.stack.platform.webworker.WebWorker;
import dev.webfx.stack.platform.webworker.spi.base.JavaCodedWebWorkerBase;

/**
 * @author Bruno Salmon
 */
public interface WorkerServiceProvider {

     WebWorker createWorker(String scriptUrl);

     WebWorker createWorker(Class<? extends JavaCodedWebWorkerBase> javaCodedWorkerClass);
}
